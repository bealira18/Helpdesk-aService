package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class AdicionarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public Servico adicionarServico(String cod,String titulo, String descricaoBreve, String descricaoCompleta, String palavrasChave, String icone) {

        final Servico novoServico = new Servico(cod,titulo, descricaoBreve, descricaoCompleta, palavrasChave, icone);

        if (!novoServico.obterTitulo().isEmpty() && !novoServico.obterDescricaoBreve().isEmpty() && !novoServico.obterDescricaoCompleta().isEmpty() && !novoServico.obterPalavrasChave().isEmpty() && !novoServico.obterIcone().obterIcone().isEmpty() && novoServico.obterFormulario()!=null && novoServico.obterWorkflow()!=null){
            novoServico.mudarCompleto(true);
            novoServico.mudarEstado(true);
        }

        return servicoRepository.save(novoServico);

    }
}
