// Generated from C:/Users/Bea/OneDrive/Documentos/lei20_21_s4_2dc_05/base.core/src/main/java/eapli/base/antlr\validarFormulario.g4 by ANTLR 4.9.1
package eapli.base.antlr.validacaoFormulario;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

/**
 * This class provides an empty implementation of {@link validarFormularioListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class validarFormularioBaseListener implements validarFormularioListener {

	private final Stack<Integer> stack;
	//formulario

	public validarFormularioBaseListener(/*formulario*/){
		this.stack=new Stack<>();
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProg(validarFormularioParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProg(validarFormularioParser.ProgContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrintExpr(validarFormularioParser.PrintExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrintExpr(validarFormularioParser.PrintExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrintCampo(validarFormularioParser.PrintCampoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrintCampo(validarFormularioParser.PrintCampoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssign(validarFormularioParser.AssignContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssign(validarFormularioParser.AssignContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlank(validarFormularioParser.BlankContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlank(validarFormularioParser.BlankContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParens(validarFormularioParser.ParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParens(validarFormularioParser.ParensContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	@Override
	public void enterMulDiv(validarFormularioParser.MulDivContext ctx) {
		stack.push(Integer.parseInt(ctx.expr(0).getText()));
		stack.push(Integer.parseInt(ctx.expr().get(1).getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitMulDiv(validarFormularioParser.MulDivContext ctx) {
		int right=stack.pop();
		int left=stack.pop();
		int result;
		if(ctx.op.getText().charAt(0)=='*'){
			result=left*right;
		}else{
			result=left/right;
		}
		stack.push(result);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterAddSub(validarFormularioParser.AddSubContext ctx) {
		stack.push(Integer.parseInt(ctx.expr(0).getText()));
		stack.push(Integer.parseInt(ctx.expr().get(1).getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitAddSub(validarFormularioParser.AddSubContext ctx) {
		int right=stack.pop();
		int left=stack.pop();
		int result;
		if(ctx.op.getText().charAt(0)=='+'){
			result=left+right;
		}else{
			result=left-right;
		}
		stack.push(result);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterId(validarFormularioParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitId(validarFormularioParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInt(validarFormularioParser.IntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInt(validarFormularioParser.IntContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	@Override
	public void enterCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx) {
		int numeroCampo=stack.pop()-1;
		if(true/*campo do formulario não esta respondido*/){
			stack.push(0);
		}else{
			stack.push(1);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx) {
		int numeroCampo=stack.pop()-1;
		if(true/*campo do formulario não esta respondido*/){
			stack.push(1);
		}else{
			stack.push(0);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx) {
		stack.push(Integer.parseInt(ctx.INT(1).getText()));
		stack.push(Integer.parseInt(ctx.INT(0).getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx) {
		int numeroCampo=stack.pop();
		int tamanho=stack.pop();
		if(true/*tamanho do campo(numeroCampo) do formulario == tamanho*/){
			stack.push(1);
		}else{
			stack.push(0);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterExpressaoRegular(validarFormularioParser.ExpressaoRegularContext ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitExpressaoRegular(validarFormularioParser.ExpressaoRegularContext ctx) {
		int numeroCampo=stack.pop()-1;
		if(true/*obter resposta do campo matche get(numeroCampo)*/){
			stack.push(1);
		}else{
			stack.push(0);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterEquals(validarFormularioParser.EqualsContext ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitEquals(validarFormularioParser.EqualsContext ctx) {
		int numeroCampo=stack.pop()-1;
		//String resposta=formularioRespondido.getResposta;
		if(true/*resposta==ctx.equival()*/){
			stack.push(1);
		}else{
			stack.push(0);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNada(validarFormularioParser.NadaContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNada(validarFormularioParser.NadaContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */

	@Override
	public void enterCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx) {
		int numeroCampo=stack.pop()-1;
		//String resposta=obter resposta de acordo com o numero do campo
		if(true/*resposta==ctx.ID*/){
			int outroCampo=(Integer.parseInt(ctx.exprCampo().getChild(0).getText()));

			if(ctx.exprCampo().getChild(2).getText().equals("ExpressaoRegular")){
				if(true/*resposta do formulario matche */){
					stack.push(1);
				}else{
					stack.push(0);
				}
			}else if(ctx.exprCampo().getChild(2).getText().equals("Vazio")){
				stack.push(1);
			}else{
				stack.push(0);
			}
		}else if(ctx.exprCampo().getChild(2).getText().equals("Obrigatorio")){
			if (true/*ver se campo esta respondido*/) {
				stack.push(1);
			}else{
				stack.push(0);
			}
		}else if(ctx.exprCampo().getChild(2).getText().equals("Tamanho")){
			int tamanho=Integer.parseInt(ctx.exprCampo().getChild(5).getText());
			if(true/*tamanho do atributo==tamanho*/){
				stack.push(1);
			}else{
				stack.push(0);
			}
		}else{
			//String respostaoutrocampo=obtreCamposFormulario.get(outrocampo).obterResposta
			if(true/*respostaoutrocampo==ctx.exprcampo.getchild(4).getchild(1).gettext*/){
				stack.push(1);
			}else{
				stack.push(0);
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterCondicaoValidacao1(validarFormularioParser.CondicaoValidacao1Context ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCondicaoValidacao1(validarFormularioParser.CondicaoValidacao1Context ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCondicaoValidacao2(validarFormularioParser.CondicaoValidacao2Context ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCondicaoValidacao2(validarFormularioParser.CondicaoValidacao2Context ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void enterQuantidade(validarFormularioParser.QuantidadeContext ctx) {
		stack.push(Integer.parseInt(ctx.INT().getText()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override
	public void exitQuantidade(validarFormularioParser.QuantidadeContext ctx) {
		int quantidade=stack.pop();
		if(true/*campoFormulario.size!=quantidade*/){
			stack.push(0);
		}else{
			stack.push(1);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}