package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarServicosController {

    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();

    public Iterable<Servico> listarServicos(){

        Iterable<Servico> servicos = servicoRepository.findAll();

        if(servicos==null)
            throw new IllegalArgumentException("Ainda não existem serviços");

        return servicos;
    }

    public Iterable<Servico> listarServicosIncompletos(){
        return servicoRepository.listarServicosIncompletos();
    }

    /*public List<Servico> listarServicosIncompletos(){

        Iterable<Servico> servicos = servicoRepository.findAll();

        if(servicos==null)
            throw new IllegalArgumentException("Ainda não existem serviços");

        List<Servico> servicosIncompletos = new ArrayList<>();

        for(Servico s : servicos){
            if (s.estaCompleto()==false){
                servicosIncompletos.add(s);
            }
        }

        return servicosIncompletos;
    }*/
}