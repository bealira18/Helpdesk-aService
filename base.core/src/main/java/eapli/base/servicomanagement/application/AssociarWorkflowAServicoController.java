package eapli.base.servicomanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;

public class AssociarWorkflowAServicoController {

    private final WorkflowRepository workflowRepository=PersistenceContext.repositories().workflow();
    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();

    public Workflow associarWorkflowAServico(int idW,String codServico){

        Servico s=verificarServico(codServico);

        Workflow w=verificarWorkflow(idW);

        if(w==null)
            throw new IllegalArgumentException("Workflow inválido com id: "+idW);

        if(s==null)
            throw new IllegalArgumentException("Serviço inválido com codigo: "+codServico);

        s.associarWorflow(w);
        servicoRepository.save(s);

        w.associarServico(s);

        return workflowRepository.save(w);

    }

    public Servico verificarServico(String codServico){

        Iterable<Servico> servicos=servicoRepository.findAll();

        for(Servico s : servicos){
            if(s.compareTo(codServico)==0)
                return s;
        }

        return null;
    }

    public Workflow verificarWorkflow(int id){

        Iterable<Workflow> workflows=workflowRepository.findAll();

        for(Workflow w : workflows){
            if(w.obterId()==id)
                return w;
        }

        return null;
    }

}
