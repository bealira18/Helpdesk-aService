package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Integer, Integer> implements DomainRepository<Integer, Servico>, ServicoRepository {

    public JpaServicoRepository(){ super("id");}

    @Override
    public Iterable<Servico> listarServicosIncompletos() {
        final TypedQuery<Servico> query = entityManager().createQuery(
                "SELECT d FROM Servico d WHERE d.completo = false",
                Servico.class);

        return query.getResultList();
    }

    @Override
    public Servico procurarPorCod(final String cod) {
        final TypedQuery<Servico> query = entityManager().createQuery(
                "SELECT d FROM Servico d WHERE cod = :COD",
                Servico.class);
        query.setParameter("COD", cod);

        Servico s=null;

        try{
            s=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return s;
    }

}
