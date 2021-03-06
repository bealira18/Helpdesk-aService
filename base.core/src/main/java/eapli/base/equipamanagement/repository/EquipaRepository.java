package eapli.base.equipamanagement.repository;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

public interface EquipaRepository extends DomainRepository<Integer, Equipa> {
    Equipa procurarPorAcronimo(Acronimo acronimo);
}
