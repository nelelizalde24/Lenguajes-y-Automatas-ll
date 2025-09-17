import org.antlr.runtime.*;

public class tes1 {
    public static void main(String[] args) throws Exception {
      ANTLRInputStream input = new ANTLRInputStream(System.in);
      expresionesLexer lexer = new expresionesLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      expresionesParser parser = new expresionesParser(tokens);
      parser.instrucciones();

      
    }
}
