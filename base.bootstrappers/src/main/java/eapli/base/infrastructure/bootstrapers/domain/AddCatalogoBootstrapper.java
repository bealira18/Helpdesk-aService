package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.framework.actions.Action;

public class AddCatalogoBootstrapper implements Action {

    CatalogoRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().catalogo();
        Catalogo catalogo1=new Catalogo("ai","breve","completaaaa",16,"icone.jpg");
        Catalogo catalogo2=new Catalogo("ui","brevemente","completamente",81,"imagem.png");
        Catalogo catalogo3=new Catalogo("ei","brevissimo","completissimo",45,"texto.jpg");
        repository.save(catalogo1);
        repository.save(catalogo2);
        repository.save(catalogo3);
        return false;
    }

}
