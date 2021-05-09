package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Integer, Integer> implements DomainRepository<Integer, Servico>, ServicoRepository {

    public JpaServicoRepository(){ super("id");}

    @Override
    public Iterable<Servico> listarServicos() {
        return match("e.apresentar=true");
    }

}
