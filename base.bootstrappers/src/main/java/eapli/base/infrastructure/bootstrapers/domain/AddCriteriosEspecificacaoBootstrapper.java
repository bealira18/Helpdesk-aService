package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.framework.actions.Action;

public class AddCriteriosEspecificacaoBootstrapper implements Action {

    CriteriosEspecificacaoRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().criteriosEspecificacao();
        CriteriosEspecificacao ce1 =new CriteriosEspecificacao(1);
        CriteriosEspecificacao ce2 =new CriteriosEspecificacao(2);
        CriteriosEspecificacao ce3 =new CriteriosEspecificacao(3);
        repository.save(ce1);
        repository.save(ce2);
        repository.save(ce3);
        return false;
    }

}