package eapli.base.equipamanagement.repository;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.framework.domain.repositories.DomainRepository;

public interface TipoEquipaRepository extends DomainRepository<Integer, TipoEquipa> {
    TipoEquipa procurarPorNome(Nome nome);
}
