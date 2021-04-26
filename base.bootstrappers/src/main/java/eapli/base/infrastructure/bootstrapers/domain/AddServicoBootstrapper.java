package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.domain.Equipa;
import eapli.base.domain.Servico;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.repositories.ServicoRepository;
import eapli.framework.actions.Action;

public class AddServicoBootstrapper implements Action {

    ServicoRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().servico();
        Servico servico1=new Servico("abc","sei la","tambem nao sei","ABC","abc.jpg");
        Servico servico2=new Servico("def","tambem nao sei","idk","OLA","ola.jpg");
        Servico servico3=new Servico("idk","idk","idkkk","IDK","idk.jpg");
        repository.save(servico1);
        repository.save(servico2);
        repository.save(servico3);
        return false;
    }

}
