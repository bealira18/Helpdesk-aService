package eapli.base.antlr;

import eapli.base.antlr.eapli.base.antlr.validarFormularioBaseVisitor;
import eapli.base.antlr.eapli.base.antlr.validarFormularioParser;

import java.util.ArrayList;
import java.util.List;

public class FormularioVisitor extends validarFormularioBaseVisitor {

    /*** "memory" for our calculator; variable/value pairs go here */
    List<Integer> ids= new ArrayList();


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitProg(validarFormularioParser.ProgContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitPrintExpr(validarFormularioParser.PrintExprContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *      *
     *      * <p>The default implementation returns the result of calling
     *      * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitPrintCondicao(validarFormularioParser.PrintCondicaoContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * ID '=' expr NEWLINE
     */
    @Override public Integer visitAssign(validarFormularioParser.AssignContext ctx){
        String id = ctx.ID().getText(); // id is left-hand side of '='
        int value = (int) visit(ctx.expr()); // compute value of expression on right
        ids.add(Integer.parseInt(id));
        //System.out.println(id+'='+value); // print the result
        return Integer.parseInt(id);
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitBlank(validarFormularioParser.BlankContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitCampoNaoPreencher(validarFormularioParser.CampoNaoPreencherContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitEquals(validarFormularioParser.EqualsContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitParens(validarFormularioParser.ParensContext ctx) {
        return visit(ctx.expr()); // return child expr's value
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitDefinirTamanho(validarFormularioParser.DefinirTamanhoContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * expr op=('*'|'/') expr
     */
    @Override public Integer visitMulDiv(validarFormularioParser.MulDivContext ctx) {
        int left = (int) visit(ctx.expr(0)); // get value of left subexpression
        int right = (int) visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getType() == validarFormularioParser.MUL) {
            return left*right; // must be MUL
        }
        return left/right; // must be DIV
    }

    /**
     * expr op=('+'|'-') expr
     */
    @Override public Integer visitAddSub(validarFormularioParser.AddSubContext ctx) {
        int left = (int) visit(ctx.expr(0)); // get value of left subexpression
        int right = (int) visit(ctx.expr(1)); // get value of right subexpression
        if (ctx.op.getType() == validarFormularioParser.ADD) {
            return left+right; // must be ADD
        }
        return left-right; // must be SUB
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitCampoObrigatorio(validarFormularioParser.CampoObrigatorioContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override public T visitMaisQualquerCoisa(validarFormularioParser.MaisQualquerCoisaContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * ID
     */
    @Override
    public Integer visitId(validarFormularioParser.IdContext ctx) {
        int id = Integer.parseInt(ctx.ID().getText());
        if (ids.contains(id)) {
            return id;
        }
        return -1;
    }

    /**
     * INT
     */
    @Override public Integer visitInt(validarFormularioParser.IntContext ctx){
        return Integer.parseInt(ctx.INT().getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitQuantidade(validarFormularioParser.QuantidadeContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitEquival(validarFormularioParser.EquivalContext ctx) {
        return visitChildren(ctx);
    }*/

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    /*@Override
    public T visitCondicaoValidacao(validarFormularioParser.CondicaoValidacaoContext ctx) {
        return visitChildren(ctx);
    }*/


}
