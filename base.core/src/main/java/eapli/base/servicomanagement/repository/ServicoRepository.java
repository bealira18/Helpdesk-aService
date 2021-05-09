package eapli.base.servicomanagement.repository;

import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

public interface ServicoRepository extends DomainRepository<Integer, Servico> {
    Iterable<Servico> listarServicos();
}
