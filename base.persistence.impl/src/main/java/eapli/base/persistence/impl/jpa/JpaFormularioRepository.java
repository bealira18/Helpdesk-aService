package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario, Integer, Integer> implements DomainRepository<Integer, Formulario>, FormularioRepository {

    public JpaFormularioRepository() {
        super("id");
    }
}
