import org.antlr.runtime.*;

public class tes1 {
    public static void main(String[] args) throws Exception {
      ANTLRInputStream input = new ANTLRInputStream(System.in);
      compiladorLexer lexer = new compiladorLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      compiladorParser parser = new compiladorParser(tokens);
      parser.program();

      
    }
}
