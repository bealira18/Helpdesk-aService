package eapli.base.antlr;

import eapli.base.antlr.validacaoFormulario.validarFormularioLexer;
import java.io.*;

import eapli.base.antlr.validacaoFormulario.validarFormularioParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class ValidarFormularioMain {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("base.core\\src\\main\\java\\eapli\\base\\antlr\\teste.txt"));

        validarFormularioLexer lexer = new validarFormularioLexer(new ANTLRInputStream(fis));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        validarFormularioParser parser = new validarFormularioParser(tokens);

        ParseTree tree = parser.prog(); // parse

        FormularioVisitor visitor = new FormularioVisitor();
        visitor.visit(tree);
    }

}
