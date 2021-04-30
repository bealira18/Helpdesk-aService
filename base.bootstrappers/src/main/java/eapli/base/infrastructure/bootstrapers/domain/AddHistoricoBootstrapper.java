package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Historico;
import eapli.base.pedidomanagement.repository.HistoricoRepository;
import eapli.framework.actions.Action;

public class AddHistoricoBootstrapper implements Action {

    HistoricoRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().historico();
        Historico h1=new Historico(1);
        Historico h2=new Historico(2);
        Historico h3=new Historico(3);
        repository.save(h1);
        repository.save(h2);
        repository.save(h3);
        return false;
    }

}
