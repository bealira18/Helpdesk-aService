package eapli.base.app.backoffice.console.presentation.colaborador;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.framework.visitor.Visitor;

public class ColaboradorPrinter implements Visitor<Colaborador> {

    @Override
    public void visit(Colaborador visited) {
        System.out.printf("%s", visited.identity());
    }

}
