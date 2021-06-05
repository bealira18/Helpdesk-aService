package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class RemoverServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public Servico procurarServicoPorCod(String cod){
        return servicoRepository.procurarPorCod(cod);
    }

    public void removerServico(String cod) {

        Servico servico = procurarServicoPorCod(cod);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um codigo inválido: " + cod);
        } else {
            servico.mudarEstado(false);
        }

        servicoRepository.save(servico);
    }

    /*public Servico procurarServicoPorCod(String cod) {

        Iterable<Servico> servicos = servicoRepository.findAll();

        Servico servico = null;

        for (Servico serv : servicos) {
            if (serv.obterCod().compareTo(cod) == 0) {
                servico = serv;
            }
        }
        return servico;
    }*/
}
