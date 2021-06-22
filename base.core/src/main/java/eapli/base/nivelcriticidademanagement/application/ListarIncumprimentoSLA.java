package eapli.base.nivelcriticidademanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;
import eapli.base.pedidomanagement.domain.Pedido;
import eapli.base.pedidomanagement.repository.PedidoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListarIncumprimentoSLA {

    private final CatalogoRepository catalogoRepository= PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();
    private final NivelCriticidadeRepository nivelCriticidade=PersistenceContext.repositories().nivelCriticidade();
    private final PedidoRepository pedidoRepository=PersistenceContext.repositories().pedido();

    public final List<Servico> ServicoPorCatalogo(int idCatalogo){

        List<Servico> servicos=new ArrayList<>();

        for(Catalogo c : catalogoRepository.findAll()){
            if(idCatalogo==c.obterId()){
                servicos=c.servicos();
            }
        }
        return servicos;
    }

    public final List<Pedido> pedidosDeServico(int idServico,List<Pedido> pedidos){
        List<Pedido> pedidosFinal=new ArrayList<>();

        for(Servico s : servicoRepository.findAll()){
            for(Pedido p : pedidos) {
                if (s.obterId() == idServico && s.estaCompleto() == true && p.obterServico().compareTo(s.obterCod())==0) {
                    pedidosFinal.add(p);
                }
            }
        }
        return pedidosFinal;
    }

    public final List<Pedido> pedidosPorData(Date dataI, Date dataF){

        List<Pedido> pedidos=new ArrayList<>();

        for(Pedido p : pedidoRepository.findAll()){
            if(p.obterDataFim()!=null) {
                if (p.obterDataSolicitacao().compareTo(dataI) > 0 && p.obterDataFim().compareTo(dataF) < 0) {
                    pedidos.add(p);
                }
            }
        }
        return pedidos;
    }

}
