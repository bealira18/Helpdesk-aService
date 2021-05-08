package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class RemoverServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public Servico procurarServicoPorTitulo(String titulo) {

        Iterable<Servico> servicos = servicoRepository.findAll();

        Servico servico = null;

        for (Servico serv : servicos) {
            if (serv.obterTitulo().compareTo(titulo) == 0) {
                servico = serv;
            }
        }
        return servico;
    }

    public void removerServico(String titulo) {

        Servico servico = procurarServicoPorTitulo(titulo);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um título inválido: " + titulo);
        } else {
            servico.mudarEstado(false);
        }

        servicoRepository.save(servico);
    }
}
