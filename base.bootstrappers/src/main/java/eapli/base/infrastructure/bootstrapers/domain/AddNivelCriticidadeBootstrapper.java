/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.framework.actions.Action;

/**
 *
 * @author 359jo
 */
public class AddNivelCriticidadeBootstrapper implements Action {

    NivelCriticidadeRepository repository;
    
    @Override
    public boolean execute() {
repository= PersistenceContext.repositories().nivelCriticidade();
        NivelCriticidade nivelCriticidade1=new NivelCriticidade("alo",1,2,3,"alo");
        NivelCriticidade nivelCriticidade2=new NivelCriticidade("alo",3,1,2,"ola");
        NivelCriticidade nivelCriticidade3=new NivelCriticidade("alo",3,2,1,"alo");
        repository.save(nivelCriticidade1);
        repository.save(nivelCriticidade2);
        repository.save(nivelCriticidade3);
        return false;    }
    
}
