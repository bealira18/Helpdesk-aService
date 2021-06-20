// Generated from C:/Users/Bea/OneDrive/Documentos/lei20_21_s4_2dc_05/base.core/src/main/java/eapli/base/antlr\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.antlr.validacaoFormulario;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link validarFormularioParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface validarFormularioVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link validarFormularioParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(validarFormularioParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(validarFormularioParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printCondicao}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(validarFormularioParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link validarFormularioParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(validarFormularioParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CampoNaoPreencher}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Equals}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquals(validarFormularioParser.EqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(validarFormularioParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefinirTamanho}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDiv}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDiv(validarFormularioParser.MulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(validarFormularioParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CampoObrigatorio}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MaisQualquerCoisa}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(validarFormularioParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(validarFormularioParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Quantidade}
	 * labeled alternative in {@link validarFormularioParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuantidade(validarFormularioParser.QuantidadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link validarFormularioParser#equival}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquival(validarFormularioParser.EquivalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CondicaoValidacao}
	 * labeled alternative in {@link validarFormularioParser#condicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx);
}