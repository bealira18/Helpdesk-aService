package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class EditarServicoController {
    
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
    
    public void mudarTitulo(String tituloAtual, String tituloNovo) {

        Servico servico = procurarServicoPorTitulo(tituloAtual);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um título inválido: " + tituloAtual);
        } else {
            servico.mudarTitulo(tituloNovo);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
    
    public void mudarDescricaoBreve(String titulo, String descricaoBreve) {

        Servico servico = procurarServicoPorTitulo(titulo);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um título inválido: " + titulo);
        } else {
            servico.mudarDescricaoBreve(descricaoBreve);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
    
     public void mudarDescricaoCompleta(String titulo, String descricaoCompleta) {

        Servico servico = procurarServicoPorTitulo(titulo);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um título inválido: " + titulo);
        } else {
            servico.mudarDescricaoCompleta(descricaoCompleta);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
     
     public void mudarPalavrasChave(String titulo, String palavrasChave) {

        Servico servico = procurarServicoPorTitulo(titulo);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um título inválido: " + titulo);
        } else {
            servico.mudarPalavrasChave(palavrasChave);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
     
     public void mudarIcone(String titulo, String novoIcone) {

        Servico servico = procurarServicoPorTitulo(titulo);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um título inválido: " + titulo);
        } else {
            servico.mudarIcone(new Icone(novoIcone));
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }

    public void verificarCompleto(Servico servico){
        if (!servico.obterTitulo().isEmpty() && !servico.obterDescricaoBreve().isEmpty() && !servico.obterDescricaoCompleta().isEmpty() && !servico.obterPalavrasChave().isEmpty() && !servico.obterIcone().obterIcone().isEmpty() && servico.obterFormulario()!=null && servico.obterWorkflow()!=null){
            servico.mudarCompleto(true);
            servico.mudarEstado(true);
        }
    }
}
