package eapli.base.colaboradormanagement.repository;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface ColaboradorRepository extends DomainRepository<Numero, Colaborador> {
    Colaborador procurarPorEmail(Email email);
    Colaborador procurarPorNomeCompleto(String nome);
    Workflow workflowAtravesTarefa(int idTarefa);
    public Servico servicoAtravesWorkflow(Workflow workflow);
    public Catalogo catalogoAtravesServico(Servico servico);
    public CriteriosEspecificacao criteriosEspecificacaoAtravesCatalogo(Catalogo catalogo);
    public List<Equipa> equipasAtravesCriteriosEspecificacao(CriteriosEspecificacao criteriosEspecificacao);
    public List<Colaborador> colaboradoresAtravesEquipa(Equipa equipa);
}
