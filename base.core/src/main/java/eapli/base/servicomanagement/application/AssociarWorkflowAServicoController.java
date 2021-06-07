package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import org.hibernate.jdbc.Work;

public class AssociarWorkflowAServicoController {

    private final WorkflowRepository workflowRepository=PersistenceContext.repositories().workflow();
    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();

    public Workflow associarWorkflowAServico(int idW,String codServico){

        Servico s=verificarServicoCod(codServico);

        Workflow w=verificarWorkflowId(idW);

        if(w==null)
            throw new IllegalArgumentException("Workflow inválido com id: "+idW);

        if(s==null)
            throw new IllegalArgumentException("Serviço inválido com codigo: "+codServico);

        s.associarWorflow(w);
        servicoRepository.save(s);

        w.associarServico(s);

        return workflowRepository.save(w);

    }

    public Servico verificarServicoCod(String cod){
        return servicoRepository.procurarPorCod(cod);
    }

    public Workflow verificarWorkflowId(int id){
        return workflowRepository.ofIdentity(id).get();
    }

}
