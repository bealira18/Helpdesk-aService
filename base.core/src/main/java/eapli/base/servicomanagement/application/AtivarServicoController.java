package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

public class AtivarServicoController {

    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();

    public void ativarServico(String cod){
        Servico s=servicoRepository.procurarPorCod(cod);

        s.mudarEstado(true);
        s.mudarCompleto(true);

        servicoRepository.save(s);
    }

}
