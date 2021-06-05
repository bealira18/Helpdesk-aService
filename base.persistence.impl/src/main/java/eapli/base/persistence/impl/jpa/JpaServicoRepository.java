package eapli.base.persistence.impl.jpa;

import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.TypedQuery;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Integer, Integer> implements DomainRepository<Integer, Servico>, ServicoRepository {

    public JpaServicoRepository(){ super("id");}

    @Override
    public Iterable<Servico> listarServicos() {
        return match("e.apresentar=true");
    }

    @Override
    public Servico procurarPorCod(final String cod) {
        final TypedQuery<Servico> query = entityManager().createQuery(
                "SELECT d FROM Servico d WHERE cod = :COD",
                Servico.class);
        query.setParameter("COD", cod);

        return query.getSingleResult();
    }

}
