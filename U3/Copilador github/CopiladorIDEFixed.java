import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import org.antlr.v4.runtime.*;

public class CopiladorIDEFixed {

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
        // Will be set true if input.txt exists at startup
        JCheckBox useFileChk = new JCheckBox("Usar input.txt");
        JButton openBtn = new JButton("Open...");
        JButton runBtn = new JButton("Run");
        JButton clearBtn = new JButton("Clear");
        controls.add(useFileChk);
        controls.add(openBtn);
        controls.add(runBtn);
        controls.add(clearBtn);

        runBtn.addActionListener(e -> {
            String codeToRun;
            if (useFileChk.isSelected()) {
                File f = new File("input.txt");
                if (!f.exists()) {
                    outputArea.setText("Archivo input.txt no encontrado en: " + System.getProperty("user.dir"));
                    return;
                }
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    codeToRun = sb.toString();
                } catch (IOException ex) {
                    outputArea.setText("Error leyendo input.txt: " + ex.getMessage());
                    return;
                }
            } else {
                codeToRun = inputArea.getText();
            }
            runParserOnText(codeToRun, outputArea);
        });

        openBtn.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            int res = fc.showOpenDialog(frame);
            if (res == JFileChooser.APPROVE_OPTION) {
                File sel = fc.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(sel))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    inputArea.setText(sb.toString());
                    useFileChk.setSelected(false);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error leyendo archivo: " + ex.getMessage());
                }
            }
        });

        clearBtn.addActionListener(e -> {
            inputArea.setText("");
            outputArea.setText("");
        });

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(controls, BorderLayout.NORTH);
        frame.getContentPane().add(split, BorderLayout.CENTER);

        // Try to load input.txt from working directory; if missing, use sample placeholder
        String defaultText = "// Pega aquí tu código Java y pulsa Run\n\npublic class Test {\n    public static void main(String[] args){\n        for(int i=0;i<3;i++){}\n    }\n}";
        File inputFile = new File("input.txt");
        String fileContents = null;
        if (inputFile.exists() && inputFile.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                fileContents = sb.toString();
                inputArea.setText(fileContents);
            } catch (IOException ex) {
                inputArea.setText(defaultText);
            }
        } else {
            inputArea.setText(defaultText);
        }

        // set checkbox state if file found
        // (it was constructed earlier as unchecked by default)
        // find the checkbox in controls and set it; since we kept a local reference, set directly
        // NOTE: we didn't keep a class-level reference, so we'll set by iterating components
        for (Component c : ((JPanel)frame.getContentPane().getComponent(0)).getComponents()) {
            if (c instanceof JCheckBox) {
                ((JCheckBox)c).setSelected(fileContents != null);
            }
        }

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
