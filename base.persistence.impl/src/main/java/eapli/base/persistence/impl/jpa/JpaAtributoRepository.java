package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaAtributoRepository extends BasepaRepositoryBase<Atributo, Integer, Integer> implements DomainRepository<Integer, Atributo>, AtributoRepository {

    public JpaAtributoRepository() {
        super("id");
    }
}