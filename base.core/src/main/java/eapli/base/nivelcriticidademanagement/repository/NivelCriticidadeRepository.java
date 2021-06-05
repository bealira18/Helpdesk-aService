package eapli.base.nivelcriticidademanagement.repository;

import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.framework.domain.repositories.DomainRepository;

public interface NivelCriticidadeRepository extends DomainRepository<Integer, NivelCriticidade>  {
    NivelCriticidade procurarPorObjetivo(String objetivo);
}
