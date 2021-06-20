// Generated from C:/Users/Bea/OneDrive/Documentos/lei20_21_s4_2dc_05/base.core/src/main/java/eapli/base/antlr\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.antlr.validacaoFormulario;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link validarFormularioParser}.
 */
public interface validarFormularioListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link validarFormularioParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(validarFormularioParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link validarFormularioParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(validarFormularioParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(validarFormularioParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(validarFormularioParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printCondicao}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printCondicao}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssign(validarFormularioParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssign(validarFormularioParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(validarFormularioParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(validarFormularioParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CampoNaoPreencher}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CampoNaoPreencher}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEquals(validarFormularioParser.EqualsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEquals(validarFormularioParser.EqualsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(validarFormularioParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(validarFormularioParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefinirTamanho}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefinirTamanho}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDiv(validarFormularioParser.MulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDiv(validarFormularioParser.MulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(validarFormularioParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(validarFormularioParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CampoObrigatorio}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CampoObrigatorio}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MaisQualquerCoisa}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MaisQualquerCoisa}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(validarFormularioParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(validarFormularioParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(validarFormularioParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(validarFormularioParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Quantidade}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterQuantidade(validarFormularioParser.QuantidadeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Quantidade}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitQuantidade(validarFormularioParser.QuantidadeContext ctx);
	/**
	 * Enter a parse tree produced by {@link validarFormularioParser#equival}.
	 * @param ctx the parse tree
	 */
	void enterEquival(validarFormularioParser.EquivalContext ctx);
	/**
	 * Exit a parse tree produced by {@link validarFormularioParser#equival}.
	 * @param ctx the parse tree
	 */
	void exitEquival(validarFormularioParser.EquivalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CondicaoValidacao}
	 * labeled alternative in {@link validarFormularioParser#condicao}.
	 * @param ctx the parse tree
	 */
	void enterCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CondicaoValidacao}
	 * labeled alternative in {@link validarFormularioParser#condicao}.
	 * @param ctx the parse tree
	 */
	void exitCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx);
}