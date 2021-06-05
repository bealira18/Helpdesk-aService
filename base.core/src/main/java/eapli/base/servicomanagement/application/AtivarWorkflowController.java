package eapli.base.servicomanagement.application;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.ServicoRepository;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.domain.TarefaManual;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

import java.util.List;

public class AtivarWorkflowController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();
    private final TarefaManualRepository tarefaManualRepository=PersistenceContext.repositories().tarefaManual();
    private final WorkflowRepository workflowRepository=PersistenceContext.repositories().workflow();

    public Workflow ativarWorkflow(Workflow w){

        w.mudarCompleto(true);

        return workflowRepository.save(w);
    }

    public Workflow ativarTarefaWorkflow(int id, Servico s){

        Formulario f=verificarFormularioID(id);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com id: "+id);

        List<Atributo> atributos=f.obterAtributos();

        if(atributos==null)
            throw new IllegalArgumentException("Este formulario ainda não contém atributos, não pode ficar ativo");

        for(Atributo a : atributos){
            if(a.obterCompleto()){
                f.mudarAtivo(true);
                f.mudarCompleto(true);
            }
        }

        formularioRepository.save(f);

        Workflow w=verificarWorkflow(s);

        verificarServico(s);

        servicoRepository.save(s);

        return workflowRepository.save(w);

    }

    public Formulario verificarFormularioID(int id){
        return formularioRepository.ofIdentity(id).get();
    }

    public boolean verificarServico(Servico servico){
        if (!servico.obterTitulo().isEmpty() && !servico.obterDescricaoBreve().isEmpty() && !servico.obterDescricaoCompleta().isEmpty() && !servico.obterPalavrasChave().isEmpty() && !servico.obterIcone().obterIcone().isEmpty() && servico.obterFormulario().estaCompleto() && servico.obterWorkflow().estaCompleto()){
            servico.mudarCompleto(true);
            servico.mudarEstado(true);
        }
        servicoRepository.save(servico);

        if(servico.estaCompleto())
            return true;

        return false;
    }

    public Workflow verificarWorkflow(Servico s){

        Workflow w=s.obterWorkflow();

        List<Tarefa> tarefas=w.obterTarefas();

        Iterable<TarefaManual> manual=tarefaManualRepository.findAll();

        for(Tarefa tar : tarefas) {
            for (TarefaManual t : manual) {
                if (tar.obterId() == t.obterId()) {
                    if (t.obterFormulario().estaCompleto() && t.obterFormulario().estaAtivo()) {
                        w.mudarCompleto(true);
                    } else
                        throw new IllegalArgumentException("Este workflow ainda não contém um formulario completo, não pode ficar ativo");
                }
            }
        }
        return w;
    }

    /*public Formulario verificarFormulario(int id){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.obterId()==id)
                return f;
        }

        return null;
    }*/

}
