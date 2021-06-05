/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.base.persistence.impl.jpa;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author 359jo
 */
public class JpaNivelCriticidadeRepository extends BasepaRepositoryBase<NivelCriticidade, Integer, Integer> implements DomainRepository<Integer, NivelCriticidade>, NivelCriticidadeRepository{
    
     public JpaNivelCriticidadeRepository(){ super("id");}

     @Override
     public NivelCriticidade procurarPorObjetivo(final String objetivo) {
          final TypedQuery<NivelCriticidade> query = entityManager().createQuery(
                  "SELECT d FROM NivelCriticidade d WHERE objetivo = :OBJETIVO",
                  NivelCriticidade.class);
          query.setParameter("OBJETIVO", objetivo);

          NivelCriticidade nc=null;

          try{
               nc=query.getSingleResult();
          }catch (NoResultException nre){
          }

          return nc;
     }
}
