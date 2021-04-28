package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.framework.actions.Action;

public class AddFormularioBootstrapper implements Action{
    
    FormularioRepository repository;

    @Override
    public boolean execute() {

        repository= PersistenceContext.repositories().formulario();
        Formulario formulario1=new Formulario("oi","io");
        Formulario formulario2=new Formulario("ui","iu");
        Formulario formulario3=new Formulario("ei","ie");
        repository.save(formulario1);
        repository.save(formulario2);
        repository.save(formulario3);
        return false;
    }
}
