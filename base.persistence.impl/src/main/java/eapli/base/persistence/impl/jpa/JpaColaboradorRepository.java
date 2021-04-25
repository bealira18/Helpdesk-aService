package eapli.base.persistence.impl.jpa;

import eapli.base.domain.Colaborador;
import eapli.base.domain.Numero;
import eapli.base.repositories.ColaboradorRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Integer, Numero> implements DomainRepository<Numero, Colaborador>, ColaboradorRepository {

    public JpaColaboradorRepository(){ super("numero");}

}
