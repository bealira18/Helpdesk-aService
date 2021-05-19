package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Icone;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class EditarServicoController {
    
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    
    public Servico procurarServicoPorCod(String cod) {

        Iterable<Servico> servicos = servicoRepository.findAll();

        Servico servico = null;

        for (Servico serv : servicos) {
            if (serv.obterCod().compareTo(cod) == 0) {
                servico = serv;
            }
        }
        return servico;
    }
    
    public void mudarTitulo(String cod, String tituloNovo) {

        Servico servico = procurarServicoPorCod(cod);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um codigo inválido: " + cod);
        } else {
            servico.mudarTitulo(tituloNovo);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
    
    public void mudarDescricaoBreve(String cod, String descricaoBreve) {

        Servico servico = procurarServicoPorCod(cod);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um codigo inválido: " + cod);
        } else {
            servico.mudarDescricaoBreve(descricaoBreve);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
    
     public void mudarDescricaoCompleta(String cod, String descricaoCompleta) {

        Servico servico = procurarServicoPorCod(cod);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um codigo inválido: " + cod);
        } else {
            servico.mudarDescricaoCompleta(descricaoCompleta);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
     
     public void mudarPalavrasChave(String cod, String palavrasChave) {

        Servico servico = procurarServicoPorCod(cod);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um codigo inválido: " + cod);
        } else {
            servico.mudarPalavrasChave(palavrasChave);
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }
     
     public void mudarIcone(String cod, String novoIcone) {

        Servico servico = procurarServicoPorCod(cod);

        if (servico == null) {
            throw new IllegalArgumentException("Este serviço tem um codigo inválido: " + cod);
        } else {
            servico.mudarIcone(new Icone(novoIcone));
        }

        verificarCompleto(servico);

        servicoRepository.save(servico);
    }

    public void verificarCompleto(Servico servico){
        if (!servico.obterTitulo().isEmpty() && !servico.obterDescricaoBreve().isEmpty() && !servico.obterDescricaoCompleta().isEmpty() && !servico.obterPalavrasChave().isEmpty() && !servico.obterIcone().obterIcone().isEmpty() && servico.obterFormulario().estaCompleto() /*&& servico.obterWorkflow()!=null*/){
            servico.mudarCompleto(true);
            servico.mudarEstado(true);
        }
    }
}
