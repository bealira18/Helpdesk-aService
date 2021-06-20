package eapli.base.antlr;

import eapli.base.antlr.validacaoFormulario.validarFormularioBaseListener;
import eapli.base.antlr.validacaoFormulario.validarFormularioParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class FormularioListener extends validarFormularioBaseListener {

    private final Stack<Integer> stack;
    //private final formulario preenchido
    private final Map<String, String> results;

    public FormularioListener(/*formulario preenchido*/){
        //this.formulario preenchido=formulario preenchido;
        this.stack=new Stack<>();
        this.results=new HashMap<>();
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterProg(validarFormularioParser.ProgContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitProg(validarFormularioParser.ProgContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPrintExpr(validarFormularioParser.PrintExprContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPrintExpr(validarFormularioParser.PrintExprContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssign(validarFormularioParser.AssignContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssign(validarFormularioParser.AssignContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlank(validarFormularioParser.BlankContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlank(validarFormularioParser.BlankContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEquals(validarFormularioParser.EqualsContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEquals(validarFormularioParser.EqualsContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterParens(validarFormularioParser.ParensContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitParens(validarFormularioParser.ParensContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx) {

    }

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
    @Override
    public void enterCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterId(validarFormularioParser.IdContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitId(validarFormularioParser.IdContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInt(validarFormularioParser.IntContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitInt(validarFormularioParser.IntContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterQuantidade(validarFormularioParser.QuantidadeContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitQuantidade(validarFormularioParser.QuantidadeContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEquival(validarFormularioParser.EquivalContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEquival(validarFormularioParser.EquivalContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {

    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {

    }

}
