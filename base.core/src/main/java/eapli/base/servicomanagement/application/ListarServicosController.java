package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class ListarServicosController {

    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();

    public Iterable<Servico> listarServicos(){

        Iterable<Servico> servicos = servicoRepository.findAll();

        if(servicos==null)
            throw new IllegalArgumentException("Ainda não existem serviços");

        return servicos;
    }

}