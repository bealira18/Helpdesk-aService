package eapli.base.persistence.impl.inmemory;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;

import java.util.List;

public class InMemoryColaboradorRepository extends InMemoryDomainRepository<Colaborador, Numero> implements ColaboradorRepository {

    static {
        InMemoryInitializer.init();
    }

    @Override
    public Colaborador procurarPorEmail(final Email email) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Colaborador procurarPorNomeCompleto(final String nome) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Workflow workflowAtravesTarefa(int idTarefa){throw new UnsupportedOperationException();}

    @Override
    public Servico servicoAtravesWorkflow(Workflow workflow){throw new UnsupportedOperationException();}

    @Override
    public Catalogo catalogoAtravesServico(Servico servico){throw new UnsupportedOperationException();}

    @Override
    public CriteriosEspecificacao criteriosEspecificacaoAtravesCatalogo(Catalogo catalogo){throw new UnsupportedOperationException();}

    @Override
    public List<Equipa> equipasAtravesCriteriosEspecificacao(CriteriosEspecificacao criteriosEspecificacao){throw new UnsupportedOperationException();}

    @Override
    public List<Colaborador> colaboradoresAtravesEquipa(Equipa equipa){throw new UnsupportedOperationException();}
}
