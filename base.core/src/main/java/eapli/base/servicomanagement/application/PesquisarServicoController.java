package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class PesquisarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public Servico procurarServicoPorTitulo(String titulo) {

        Iterable<Servico> servicos = servicoRepository.findAll();

        Servico servico = null;

        for (Servico s : servicos) {
            if (s.obterTitulo().equalsIgnoreCase(titulo)) {
                servico = s;
            }
        }
        return servico;
    }
}