package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaCriteriosEspecificacaoRepository extends BasepaRepositoryBase<CriteriosEspecificacao, Integer, Integer> implements DomainRepository<Integer, CriteriosEspecificacao>, CriteriosEspecificacaoRepository {

    public JpaCriteriosEspecificacaoRepository(){ super("numero");}

}