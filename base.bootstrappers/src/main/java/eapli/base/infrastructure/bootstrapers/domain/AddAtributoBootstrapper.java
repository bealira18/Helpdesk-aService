package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class AddAtributoBootstrapper implements Action {

    AtributoRepository repository;

    @Override
    public boolean execute() {

        repository = PersistenceContext.repositories().atributo();
        Atributo atributo1 = new Atributo("oi", "io", "xau", "String");
        Atributo atributo2 = new Atributo("ui", "iu", "ei", "Integer");
        Atributo atributo3 = new Atributo("ei", "ie", "benfica", "Float");
        repository.save(atributo1);
        repository.save(atributo2);
        repository.save(atributo3);
        return false;
    }
}