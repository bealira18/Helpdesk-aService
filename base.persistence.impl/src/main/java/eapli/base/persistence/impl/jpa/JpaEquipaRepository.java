package eapli.base.persistence.impl.jpa;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaEquipaRepository extends BasepaRepositoryBase<Equipa, Integer, Integer> implements DomainRepository<Integer, Equipa>, EquipaRepository {

    public JpaEquipaRepository(){ super("id");}

    @Override
    public Equipa procurarPorAcronimo(final Acronimo acronimo) {
        final TypedQuery<Equipa> query = entityManager().createQuery(
                "SELECT d FROM Equipa d WHERE acronimo = :ACRONIMO",
                Equipa.class);
        query.setParameter("ACRONIMO", acronimo);

        Equipa e=null;

        try{
            e=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return e;
    }

}
