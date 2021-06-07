package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.application.ListarCatálogosEServicosController;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class PesquisarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    private final ListarCatálogosEServicosController listarCatálogosEServicosController=new ListarCatálogosEServicosController();

    public Servico procurarServicoEspecifico(String codigo,int numeroColaborador){

        Iterable<Servico> servicos = listarCatálogosEServicosController.listarServicosDeCatalogo(numeroColaborador);

        Servico servico = null;

        for (Servico s : servicos) {
            if (s.obterCod().equalsIgnoreCase(codigo)) {
                servico = s;
            }
        }
        return servico;

    }

    public Servico procurarPorCod(String cod){
        return servicoRepository.procurarPorCod(cod);
    }

}