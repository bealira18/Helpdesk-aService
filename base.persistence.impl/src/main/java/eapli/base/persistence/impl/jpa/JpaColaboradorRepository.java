package eapli.base.persistence.impl.jpa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Integer, Numero> implements DomainRepository<Numero, Colaborador>, ColaboradorRepository {

    public JpaColaboradorRepository(){ super("numero");}

}
