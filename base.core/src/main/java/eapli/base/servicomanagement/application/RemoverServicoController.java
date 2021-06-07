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

}
