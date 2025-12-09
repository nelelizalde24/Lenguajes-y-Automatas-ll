import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import org.antlr.runtime.*;

public class MiniIDE {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("MiniIDE - Compilador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        JTextArea sourceArea = new JTextArea();
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(sourceArea), new JScrollPane(outputArea));
        split.setDividerLocation(350);

        JButton parseBtn = new JButton("Parse / Run Analysis");
        parseBtn.addActionListener(e -> {
            String src = sourceArea.getText();
            if (src == null || src.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Ingrese código en el área superior.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            // Redirect System.out and System.err to capture parser messages and errors
            PrintStream originalOut = System.out;
            PrintStream originalErr = System.err;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            System.setOut(ps);
            System.setErr(ps);
            try {
                CharStream input = new ANTLRStringStream(src);
                compiladorLexer lexer = new compiladorLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                compiladorParser parser = new compiladorParser(tokens);
                parser.program();
            } catch (Throwable ex) {
                ex.printStackTrace(ps);
            } finally {
                ps.flush();
                System.setOut(originalOut);
                System.setErr(originalErr);
            }

            // Show captured output in outputArea
            String out = baos.toString();
            if (out == null || out.trim().isEmpty()) {
                out = "(No output captured)\n" +
                      "Nota: la gramática espera 'accessmod class ID { ... }' — por ejemplo: 'public class Test { ... }'.\n" +
                      "Si tu código no contiene 'public/private/protected' antes de 'class', no será reconocido.\n";
            }
            outputArea.setText(out);
        });

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        bottom.add(parseBtn);

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(split, BorderLayout.CENTER);
        frame.getContentPane().add(bottom, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
