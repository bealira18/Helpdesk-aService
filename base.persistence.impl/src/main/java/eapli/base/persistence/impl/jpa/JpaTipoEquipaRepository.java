package eapli.base.persistence.impl.jpa;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaTipoEquipaRepository extends BasepaRepositoryBase<TipoEquipa, Integer, Integer> implements DomainRepository<Integer, TipoEquipa>, TipoEquipaRepository {

    public JpaTipoEquipaRepository(){ super("id");}

    @Override
    public TipoEquipa procurarPorNome(final Nome nome) {
        final TypedQuery<TipoEquipa> query = entityManager().createQuery(
                "SELECT d FROM TipoEquipa d WHERE nome = :NOME",
                TipoEquipa.class);
        query.setParameter("NOME", nome);

        TipoEquipa te=null;

        try{
            te=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return te;
    }
}
