import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import org.antlr.v4.runtime.*;

public class CopiladorIDE {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Copilador IDE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        JTextArea inputArea = new JTextArea();
        inputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                new JScrollPane(inputArea), new JScrollPane(outputArea));
        split.setResizeWeight(0.65);

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton runBtn = new JButton("Run");
        JButton clearBtn = new JButton("Clear");
        controls.add(runBtn);
        controls.add(clearBtn);

        runBtn.addActionListener(e -> {
            runParserOnText(inputArea.getText(), outputArea);
        });

        clearBtn.addActionListener(e -> {
            inputArea.setText("");
            outputArea.setText("");
        });

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(controls, BorderLayout.NORTH);
        frame.getContentPane().add(split, BorderLayout.CENTER);

        // Sample placeholder text
        inputArea.setText("// Pega aquí tu código Java y pulsa Run\n\npublic class Test {\n    public static void main(String[] args){\n        for(int i=0;i<3;i+");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void runParserOnText(String code, JTextArea outputArea) {
        // Ejecuta el parser en memoria y captura System.out
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;

        try {
            System.setOut(ps);

            CharStream input = CharStreams.fromString(code);
            JavaLexer lexer = new JavaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            JavaParser parser = new JavaParser(tokens);

            // Ejecuta la regla inicial
            parser.compilationUnit();

        } catch (Throwable ex) {
            ex.printStackTrace(ps);
        } finally {
            System.out.flush();
            System.setOut(oldOut);
        }

        try {
            String outText = baos.toString("UTF-8");
            outputArea.setText(outText);
        } catch (UnsupportedEncodingException ex) {
            outputArea.setText("Error al leer la salida: " + ex.getMessage());
        }
    }
}
