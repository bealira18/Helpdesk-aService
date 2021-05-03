package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.actions.Action;

public class AddTipoEquipaBootstrapper implements Action {

    TipoEquipaRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().tipoEquipa();
        TipoEquipa te1=new TipoEquipa("abc","#123456");
        TipoEquipa te2=new TipoEquipa("def","#654321");
        TipoEquipa te3=new TipoEquipa("idk","#qwerty");
        repository.save(te1);
        repository.save(te2);
        repository.save(te3);
        return false;
    }

}
