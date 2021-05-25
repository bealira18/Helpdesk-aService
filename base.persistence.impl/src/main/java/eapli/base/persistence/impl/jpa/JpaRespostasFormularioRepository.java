package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.RespostasFormulario;
import eapli.base.formulariomanagement.repository.RespostasFormularioRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaRespostasFormularioRepository extends BasepaRepositoryBase<RespostasFormulario, Integer, Integer> implements RespostasFormularioRepository {

    public JpaRespostasFormularioRepository() {
        super("id");
    }

}
