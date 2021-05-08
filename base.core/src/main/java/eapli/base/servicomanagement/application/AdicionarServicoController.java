package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class AdicionarServicoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();

    public Servico adicionarServico(String titulo, String descricaoBreve, String descricaoCompleta, String palavrasChave, String icone) {

        final Servico novoServico = new Servico(titulo, descricaoBreve, descricaoCompleta, palavrasChave, icone);

        return servicoRepository.save(novoServico);

    }
}
