package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Integer, Numero> implements DomainRepository<Numero, Colaborador>, ColaboradorRepository {

    public JpaColaboradorRepository(){ super("numero");}

    @Override
    public Colaborador procurarPorEmail(final Email email) {
        final TypedQuery<Colaborador> query = entityManager().createQuery(
                "SELECT d FROM Colaborador d WHERE email = :EMAIL",
                Colaborador.class);
        query.setParameter("EMAIL", email);

        Colaborador c=null;

        try{
            c=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return c;
    }

    @Override
    public Colaborador procurarPorNomeCompleto(final String nomeCompleto) {
        final TypedQuery<Colaborador> query = entityManager().createQuery(
                "SELECT d FROM Colaborador d WHERE nomeCompleto = :NOMECOMPLETO",
                Colaborador.class);
        query.setParameter("NOMECOMPLETO", nomeCompleto);

        Colaborador c=null;

        try{
            c=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return c;
    }

    @Override
    public Workflow workflowAtravesTarefa(int idTarefa){
        final TypedQuery<Workflow> query = entityManager().createQuery(
                "SELECT DISTINCT w FROM Workflow w, Tarefa t WHERE t.id= :ID AND t IN (SELECT tar FROM w.tarefas tar)",
                Workflow.class);

        query.setParameter("ID",idTarefa);

        return query.getSingleResult();
    }

    @Override
    public Servico servicoAtravesWorkflow(Workflow workflow){
        final TypedQuery<Servico> query = entityManager().createQuery(
                "SELECT DISTINCT s FROM Servico s WHERE s.workflow= :WORKFLOW",
                Servico.class);

        query.setParameter("WORKFLOW",workflow);

        return query.getSingleResult();
    }

    @Override
    public Catalogo catalogoAtravesServico(Servico servico){
        final TypedQuery<Catalogo> query = entityManager().createQuery(
                "SELECT DISTINCT c FROM Catalogo c WHERE :SERVICO IN (SELECT s FROM c.servicos s)",
                Catalogo.class);

        query.setParameter("SERVICO",servico);

        return query.getSingleResult();
    }

    @Override
    public CriteriosEspecificacao criteriosEspecificacaoAtravesCatalogo(Catalogo catalogo){
        final TypedQuery<CriteriosEspecificacao> query = entityManager().createQuery(
                "SELECT DISTINCT c.criteriosEspecificaçao FROM Catalogo c WHERE c= :CATALOGO",
                CriteriosEspecificacao.class);

        query.setParameter("CATALOGO",catalogo);

        return query.getSingleResult();
    }

    @Override
    public List<Equipa> equipasAtravesCriteriosEspecificacao(CriteriosEspecificacao criteriosEspecificacao){
        final TypedQuery<Equipa> query = entityManager().createQuery(
                "SELECT DISTINCT e FROM Equipa e,CriteriosEspecificacao ce WHERE ce= :CRITERIOSESPECIFICACAO AND ce IN(SELECT eq FROM ce.equipas eq)",
                Equipa.class);

        query.setParameter("CRITERIOSESPECIFICACAO",criteriosEspecificacao);

        return query.getResultList();
    }

    @Override
    public List<Colaborador> colaboradoresAtravesEquipa(Equipa equipa){
        final TypedQuery<Colaborador> query = entityManager().createQuery(
                "SELECT DISTINCT c FROM Colaborador c WHERE c.equipa= :EQUIPA",
                Colaborador.class);

        query.setParameter("EQUIPA",equipa);

        return query.getResultList();
    }

}
