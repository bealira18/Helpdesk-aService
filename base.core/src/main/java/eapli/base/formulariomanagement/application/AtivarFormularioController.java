package eapli.base.formulariomanagement.application;

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
import eapli.base.tarefamanagement.repository.TarefaRepository;

import java.util.ArrayList;
import java.util.List;

public class AtivarFormularioController {

    private final FormularioRepository formularioRepository= PersistenceContext.repositories().formulario();
    private final ServicoRepository servicoRepository= PersistenceContext.repositories().servico();
    private final TarefaManualRepository tarefaManualRepository=PersistenceContext.repositories().tarefaManual();
    private final WorkflowRepository workflowRepository=PersistenceContext.repositories().workflow();

    public Formulario ativarFormServico(String nomeFormulario,Servico s){

        Formulario f=verificarFormulario(nomeFormulario);

        if(f==null)
            throw new IllegalArgumentException("Formulario inválido com nome: "+nomeFormulario);

        List<Atributo> atributos=f.obterAtributos();

        if(atributos==null)
            throw new IllegalArgumentException("Este formulario ainda não contém atributos, não pode ficar ativo");

        for(Atributo a : atributos){
            if(a.obterCompleto()){
                f.mudarAtivo(true);
                f.mudarCompleto(true);
            }
        }

        verificarServico(s);

        formularioRepository.save(f);

        servicoRepository.save(s);


        return formularioRepository.save(f);
    }

    public Formulario verificarFormulario(String nomeFormulario){

        Iterable<Formulario> formularios=formularioRepository.findAll();

        for(Formulario f : formularios){
            if(f.compareTo(nomeFormulario)==0)
                return f;
        }

        return null;
    }

    public void verificarServico(Servico servico){
        if (!servico.obterTitulo().isEmpty() && !servico.obterDescricaoBreve().isEmpty() && !servico.obterDescricaoCompleta().isEmpty() && !servico.obterPalavrasChave().isEmpty() && !servico.obterIcone().obterIcone().isEmpty() && servico.obterFormulario().estaCompleto() && servico.obterWorkflow().estaCompleto()){
            servico.mudarCompleto(true);
            servico.mudarEstado(true);
        }
        servicoRepository.save(servico);

    }

}
