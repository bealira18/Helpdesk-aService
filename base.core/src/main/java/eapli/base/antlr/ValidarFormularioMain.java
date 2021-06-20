package eapli.base.antlr;

import java.io.*;

import eapli.base.antlr.validacaoFormulario.validarFormularioLexer;
import eapli.base.antlr.validacaoFormulario.validarFormularioParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ValidarFormularioMain {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(new File("base.core\\src\\main\\java\\eapli\\base\\antlr\\testeFormulario.txt"));

        validarFormularioLexer lexer = new validarFormularioLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validarFormularioParser parser = new validarFormularioParser(tokens);

        ParseTree tree = parser.prog(); // parse
        ParseTreeWalker walker=new ParseTreeWalker();

        FormularioListener listener=new FormularioListener();
        walker.walk(listener,tree);

        FormularioVisitor visitor = new FormularioVisitor();
        visitor.visit(tree);

        System.out.println(listener.getResults());
    }

}
