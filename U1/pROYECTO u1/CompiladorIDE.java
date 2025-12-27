import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

public class CompiladorIDE {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Compilador IDE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 700);

        JTextArea editor = new JTextArea();
        editor.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));

        JTextArea output = new JTextArea();
        output.setEditable(false);
        output.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));

        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(editor), new JScrollPane(output));
        split.setResizeWeight(0.7);

        JToolBar toolbar = new JToolBar();
        JButton openBtn = new JButton("Open");
        JButton compileBtn = new JButton("Compile");
        JButton clearBtn = new JButton("Clear");
        toolbar.add(openBtn);
        toolbar.add(compileBtn);
        toolbar.add(clearBtn);

        openBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) sb.append(line).append("\n");
                    editor.setText(sb.toString());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error leyendo archivo: " + ex.getMessage());
                }
            }
        });

        clearBtn.addActionListener(e -> { editor.setText(""); output.setText(""); });

        compileBtn.addActionListener(e -> {
            String code = editor.getText();
            output.setText(compileAndAnalyze(code));
        });

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(toolbar, BorderLayout.NORTH);
        frame.getContentPane().add(split, BorderLayout.CENTER);

        // sample placeholder
        editor.setText("public class NombreClase {\n    void hazAlgo(int x, double f) { }\n    private int x1, y, z;\n    protected double ejemplo(int x, double w, double n) {\n        x = ((n+i10-k78)*fg+jk+345);\n        int x, v, z, f, g, h;\n        double f, g;\n        y = ((n+i10-k78)*fg+jk*3.45);\n        int x;\n    }\n    double f, g, h;\n}\n");

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static String compileAndAnalyze(String code) {
        StringBuilder out = new StringBuilder();
        try {
            ANTLRStringStream input = new ANTLRStringStream(code);
            compiladorLexer lexer = new compiladorLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            compiladorParser parser = new compiladorParser(tokens);
            compiladorParser.program_return r = parser.program();
            CommonTree tree = (CommonTree)r.getTree();

            SemanticAnalyzer3 sem = new SemanticAnalyzer3();
            List<String> errs = sem.analyze(tree);
            if (errs.isEmpty()) out.append("Compilación correcta. No se detectaron errores semánticos.\n");
            else for (String s: errs) out.append(s).append('\n');
        } catch (Throwable ex) {
            out.append("Error durante el parseo/analisis: ").append(ex.getMessage()).append('\n');
            StringWriter sw = new StringWriter(); ex.printStackTrace(new PrintWriter(sw)); out.append(sw.toString());
        }
        return out.toString();
    }
}
