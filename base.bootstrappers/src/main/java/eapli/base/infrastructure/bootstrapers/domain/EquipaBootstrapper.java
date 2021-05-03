package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.application.CriarEquipaController;
import eapli.framework.actions.Action;

public class EquipaBootstrapper implements Action {

//EquipaRepository repository;
//    @Override
//    public boolean execute() {
//
//        repository= PersistenceContext.repositories().equipa();
//        Equipa equipa1=new Equipa("abc","sei la");
//        Equipa equipa2=new Equipa("def","tambem nao sei");
//        Equipa equipa3=new Equipa("idk","idk");
//        repository.save(equipa1);
//        repository.save(equipa2);
//        repository.save(equipa3);
//        return false;
//    }
    private final CriarEquipaController controller = new CriarEquipaController();

    @Override
    public boolean execute() {

        controller.criarEquipa("EDF", "Equipa dos Fixolas");
        controller.criarEquipa("EDC", "Equipa dos Campeoes");
        
        return true;
    }
}
