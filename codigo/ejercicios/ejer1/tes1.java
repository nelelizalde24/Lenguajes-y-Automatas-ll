import org.antlr.runtime.*;

public class Tes1 {
    public static void main(String[] args) throws Exception {
      ANTLRInputStream input = new ANTLRInputStream(System.in);
      ejercicio1Lexer lexer = new ejercicio1Lexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      ejercicio1Parser parser = new ejercicio1Parser(tokens);
      parser.programa();
    }
}
