/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.domain.NivelCriticidade;
import eapli.base.repositories.NivelCriticidadeRepository;
import eapli.framework.domain.repositories.DomainRepository;

/**
 *
 * @author 359jo
 */
public class JpaNivelCriticidadeRepository extends BasepaRepositoryBase<NivelCriticidade, Integer, Integer> implements DomainRepository<Integer, NivelCriticidade>, NivelCriticidadeRepository{
    
     public JpaNivelCriticidadeRepository(){ super("id");}
    
}
