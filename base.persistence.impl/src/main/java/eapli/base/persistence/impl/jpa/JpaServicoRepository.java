package eapli.base.persistence.impl.jpa;

import eapli.base.domain.Pedido;
import eapli.base.domain.Servico;
import eapli.base.repositories.PedidoRepository;
import eapli.base.repositories.ServicoRepository;
import eapli.framework.domain.repositories.DomainRepository;

public class JpaServicoRepository extends BasepaRepositoryBase<Servico, Integer, Integer> implements DomainRepository<Integer, Servico>, ServicoRepository {

    public JpaServicoRepository(){ super("id");}

}
