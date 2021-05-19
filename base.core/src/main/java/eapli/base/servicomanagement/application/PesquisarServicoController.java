package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class PesquisarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public Servico procurarServicoPorCod(String codigo) {

        Iterable<Servico> servicos = servicoRepository.findAll();

        Servico servico = null;

        for (Servico s : servicos) {
            if (s.obterCod().equalsIgnoreCase(codigo)) {
                servico = s;
            }
        }
        return servico;
    }
}