// Generated from MiLenguaje.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiLenguajeParser}.
 */
public interface MiLenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MiLenguajeParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MiLenguajeParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(MiLenguajeParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(MiLenguajeParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#asign}.
	 * @param ctx the parse tree
	 */
	void enterAsign(MiLenguajeParser.AsignContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#asign}.
	 * @param ctx the parse tree
	 */
	void exitAsign(MiLenguajeParser.AsignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MiLenguajeParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MiLenguajeParser.ExprContext ctx);
}