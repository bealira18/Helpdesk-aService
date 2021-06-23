package eapli.base.tarefamanagement.application;

import api.SendEmail;
import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.domain.Workflow;
import eapli.base.servicomanagement.repository.WorkflowRepository;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;
import eapli.base.tarefamanagement.repository.TarefaManualRepository;

import java.util.*;

public class AtribuirTarefaManualController {

    private final TarefaManualRepository tarefaManualRepository = PersistenceContext.repositories().tarefaManual();
    private final WorkflowRepository workflowRepository = PersistenceContext.repositories().workflow();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ColaboradorRepository colaboradorRepository=PersistenceContext.repositories().colaborador();
    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public boolean atribuirTarefas1(InfoTarefa t1){
        //int idTarefa = t1.obteridTarefa();
        List<Colaborador> colaboradoresDisponiveis = obterColaboradoresDisponiveis(t1);
        Date dataUltimaTarefaDoColaborador = null;
        Colaborador colaboradorEscolhido = null;
        if(colaboradoresDisponiveis.size()==0){
            System.out.println("Não existem colaboradores disponíveis para a tarefa"+t1.obterId()+"!\n");
            return false;
        }
        if(colaboradoresDisponiveis.size()==1){
            colaboradorEscolhido = colaboradoresDisponiveis.get(0);
            System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1, pelo facto de só haver um colaborador disponível!\n", t1.obterId());
            guardarColaboradorEscolhido(colaboradorEscolhido, t1);
            return true;
        }

        for(Colaborador c : colaboradoresDisponiveis){
            List<InfoTarefa> list = c.tarefas();
            if(list.size()==0){
                colaboradorEscolhido = c;
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1, porque o colaborador não tinha qualquer tarefa!\n", t1.obterId());
                guardarColaboradorEscolhido(colaboradorEscolhido, t1);
                return true;
            }
        }

        Colaborador primeiroColaborador = null;
        for (Colaborador c : colaboradoresDisponiveis){
            List<InfoTarefa> its = c.tarefas();
            for( InfoTarefa it : its){
                if(it.obterDataFim() != null){
                    if(dataUltimaTarefaDoColaborador==null){
                        dataUltimaTarefaDoColaborador = it.obterDataFim();
                        colaboradorEscolhido = c;
                        primeiroColaborador = c;
                    }
                    if(it.obterDataFim().compareTo(dataUltimaTarefaDoColaborador)>0){
                        dataUltimaTarefaDoColaborador = it.obterDataFim();
                    }
                }
            }
            if (dataUltimaTarefaDoColaborador != null && colaboradorEscolhido != null){
                break;
            }
        }
        if(dataUltimaTarefaDoColaborador == null && colaboradorEscolhido == null){
            atribuirTarefas2(t1);
            return false;
        }
        Date dataUltimaTarefaMaisAntiga = dataUltimaTarefaDoColaborador;
        for(Colaborador c : colaboradoresDisponiveis){
            if(c!=primeiroColaborador){
                List<InfoTarefa> ts = c.tarefas();
                for( InfoTarefa it : ts) {
                    if (it.obterDataFim() != null) {
                        dataUltimaTarefaDoColaborador = it.obterDataFim();
                    }
                }
            }
            List<InfoTarefa> tarefasColaborador = c.tarefas();
            for (InfoTarefa it : tarefasColaborador){
                if(it.obterDataFim()!= null) {
                    if (it.obterDataFim().compareTo(dataUltimaTarefaDoColaborador) > 0) {
                        dataUltimaTarefaDoColaborador = it.obterDataFim();
                    }
                }
            }
            if(c==primeiroColaborador){
                dataUltimaTarefaMaisAntiga = dataUltimaTarefaDoColaborador;
                colaboradorEscolhido = c;
            }
            int contadorTarefasNaoTerminadasC = 0;
            List<InfoTarefa> tarefas = c.tarefas();
            for (InfoTarefa it : tarefas){
                if (it.obterEstado()==EstadoTarefa.ATRIBUIDA || it.obterEstado()==EstadoTarefa.EM_EXECUÇAO){
                    contadorTarefasNaoTerminadasC++;
                }
            }
            int contadorTarefasNaoTerminadasColaboradorEscolhido = 0;
            List<InfoTarefa> tarefasEscolhido = colaboradorEscolhido.tarefas();
            for (InfoTarefa it : tarefasEscolhido){
                if (it.obterEstado()==EstadoTarefa.ATRIBUIDA || it.obterEstado()==EstadoTarefa.EM_EXECUÇAO){
                    contadorTarefasNaoTerminadasColaboradorEscolhido++;
                }
            }
            if(contadorTarefasNaoTerminadasC==0) {
                if((dataUltimaTarefaDoColaborador.compareTo(dataUltimaTarefaMaisAntiga) < 0) || (contadorTarefasNaoTerminadasColaboradorEscolhido != 0)) {
                    dataUltimaTarefaMaisAntiga = dataUltimaTarefaDoColaborador;
                    colaboradorEscolhido = c;
                }
            }
        }

        int contadorTarefasNaoTerminadas = 0;
        List<InfoTarefa> tarefas = colaboradorEscolhido.tarefas();
        for (InfoTarefa it : tarefas){
            if (it.obterEstado()==EstadoTarefa.ATRIBUIDA || it.obterEstado()==EstadoTarefa.EM_EXECUÇAO){
                contadorTarefasNaoTerminadas++;
            }
        }
        if(contadorTarefasNaoTerminadas!=0) {
            atribuirTarefas2(t1);
            return true;
        }

        /*Colaborador colaboradorEscolhido = colaboradoresDisponiveis.get(0);
        List<InfoTarefa> tarefasEscolhido = colaboradorEscolhido.tarefas();
        Date dataUltimaTarefa = tarefasEscolhido.get(0).obterDataFim();
        Date dataUltimaTarefaMaisAntiga = dataUltimaTarefa;
        for(InfoTarefa it : tarefasEscolhido){
            if (it.obterDataFim().compareTo(dataUltimaTarefa)>0){
                dataUltimaTarefa = it.obterDataFim();
            }
        }
        dataUltimaTarefaMaisAntiga = dataUltimaTarefa;
        for(Colaborador c : colaboradoresDisponiveis){
            List<InfoTarefa> tarefas = c.tarefas();
            for(InfoTarefa it1 : tarefas){
                if (it1.obterDataFim().compareTo(dataUltimaTarefa)>0){
                    dataUltimaTarefa = it1.obterDataFim();
                    colaboradorEscolhido = c;
                }
            }
        }*/
        System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 1!\n", t1.obterId());
        guardarColaboradorEscolhido(colaboradorEscolhido, t1);
        return true;
    }

    public boolean atribuirTarefas2(InfoTarefa t2){
        //int idTarefa = t2.obteridTarefa();
        List<Colaborador> colaboradoresDisponiveis = obterColaboradoresDisponiveis(t2);
        Colaborador colaboradorEscolhido = null;
        List<InfoTarefa> tarefasEscolhido = new ArrayList<>();
        if(colaboradoresDisponiveis.size()==0){
            System.out.println("Não existem colaboradores disponíveis para a tarefa"+t2.obterId()+"!\n");
            return true;
        }
        if(colaboradoresDisponiveis.size()==1){
            colaboradorEscolhido = colaboradoresDisponiveis.get(0);
            System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2, pelo facto de só haver um colaborador disponível!\n", t2.obterId());
            guardarColaboradorEscolhido(colaboradorEscolhido, t2);
        }

        for(Colaborador c : colaboradoresDisponiveis){
            int tarefasPendentes = 0;
            List<InfoTarefa> list = c.tarefas();
            if(list.size()==0){
                colaboradorEscolhido = c;
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2, porque o colaborador não tinha qualquer tarefa!\n", t2.obterId());
                guardarColaboradorEscolhido(colaboradorEscolhido, t2);
            }
            for(InfoTarefa it : list){
                if(it.obterEstado()==EstadoTarefa.ATRIBUIDA || it.obterEstado()==EstadoTarefa.EM_EXECUÇAO){
                    tarefasPendentes++;
                }
            }
            if(tarefasPendentes==0){
                colaboradorEscolhido = c;
                System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2, porque o colaborador não tinha tarefas pendentes!\n", t2.obterId());
                guardarColaboradorEscolhido(colaboradorEscolhido, t2);
            }
        }
        int tempoMedioEscolhido = 0;
        colaboradorEscolhido=colaboradoresDisponiveis.get(0);
        tarefasEscolhido=colaboradorEscolhido.tarefas();
        for(InfoTarefa it : tarefasEscolhido){
            if (it.obterEstado()!=EstadoTarefa.TERMINADA){
                tempoMedioEscolhido += it.obterTarefa().obterTempoMedio();
            }
        }
        for(Colaborador c : colaboradoresDisponiveis){
            int tempoMedio = 0;
            List<InfoTarefa> tarefas = c.tarefas();
            for(InfoTarefa it1 : tarefas){
                if (it1.obterEstado()!=EstadoTarefa.TERMINADA){
                    tempoMedio += it1.obterTarefa().obterTempoMedio();
                }
            }
            if (tempoMedio < tempoMedioEscolhido){
                tempoMedioEscolhido = tempoMedio;
                colaboradorEscolhido = c;
            }
        }
        System.out.printf("InfoTarefa com o id %d atribuída com sucesso pela forma 2!\n", t2.obterId());
        guardarColaboradorEscolhido(colaboradorEscolhido, t2);
        return true;
    }

    public void guardarColaboradorEscolhido(Colaborador colaboradorEscolhido, InfoTarefa infoTarefa){
        colaboradorEscolhido.reivindicarTarefa(infoTarefa);
        infoTarefa.associarColaborador(colaboradorEscolhido);
        infoTarefa.mudarEstado(EstadoTarefa.ATRIBUIDA);
        colaboradorRepository.save(colaboradorEscolhido);
        infoTarefaRepository.save(infoTarefa);
        enviarEmail(colaboradorEscolhido);
        System.out.printf("Email enviado para o colaborador %s!\n", colaboradorEscolhido.obterNomeCompleto());
    }

    /*public void fcfs(){

        List<InfoTarefa> tarefasPorAtribuir = (List<InfoTarefa>) listarTarefasPendentes();
        while(tarefasPorAtribuir.size()!=0) {
            InfoTarefa tarefa1 = tarefasPorAtribuir.get(0);
            for (InfoTarefa t : tarefasPorAtribuir) {
                if (t.obterDataInicio().compareTo(tarefa1.obterDataInicio()) < 0) {
                    tarefa1 = t;
                }
            }
            if(tarefa1.obterTarefa().obterOption() == 1){
                atribuirTarefas1(tarefa1);
            }
            if(tarefa1.obterTarefa().obterOption() == 2){
                atribuirTarefas2(tarefa1);
            }
            tarefasPorAtribuir.remove(tarefa1);
        }
    }*/

    public List<InfoTarefa> fcfs() {

        List<InfoTarefa> tarefasPorAtribuir = (List<InfoTarefa>) listarTarefasPendentes();
        Collections.sort(tarefasPorAtribuir, new Comparator<InfoTarefa>() {
            @Override
            public int compare(InfoTarefa it1, InfoTarefa it2) {
                return it1.obterDataInicio().compareTo(it2.obterDataInicio());
            }
        });
        return tarefasPorAtribuir;
    }

    /*public void fcfs(){

        List<InfoTarefa> tarefasPorAtribuir = (List<InfoTarefa>) listarTarefasPendentes();
        InfoTarefa tarefa1 = tarefasPorAtribuir.get(0);
        for (InfoTarefa t : tarefasPorAtribuir) {
            if (t.obterDataInicio().compareTo(tarefa1.obterDataInicio()) < 0) {
                tarefa1 = t;
            }
        }
        if(tarefa1.obterTarefa().obterOption() == 1){
            atribuirTarefas1(tarefa1);
        }
        if(tarefa1.obterTarefa().obterOption() == 2){
            atribuirTarefas2(tarefa1);
        }
        //tarefasPorAtribuir.remove(tarefa1); Não preciso de remover porque a próxima thread vai fazer novamente o método
        // listarTarefasPendentes() e como esta já foi atribuída, já não vai aparecer.
    }*/

    /*public List<InfoTarefa> listarTarefasPendentes(){
        List<TarefaManual> tarefasManuais = (List<TarefaManual>) tarefaManualRepository.findAll();
        List<InfoTarefa> tarefas = procurarTarefasManuaisNaoAtribuidas();
        //List<InfoTarefa> tarefas = (List<InfoTarefa>) infoTarefaRepository.findAll();
        List<InfoTarefa> tarefasPendentes = new ArrayList<>();
        for (InfoTarefa it : tarefas){
            for (TarefaManual tm : tarefasManuais){
                if(it.obteridTarefa()==tm.obterId() && it.obterEstado()== EstadoTarefa.NAO_INICIADA){
                    tarefasPendentes.add(it);
                }
            }
        }
        return tarefasPendentes;
    }*/

    public Iterable<InfoTarefa> listarTarefasPendentes(){
        return tarefaManualRepository.procurarTarefasManuaisNaoAtribuidas();
    }

    public List<Colaborador> obterColaboradoresDisponiveis(InfoTarefa t1){
        int idTarefa = t1.obteridTarefa();
        Iterable<Workflow> workflows = workflowRepository.findAll();
        Workflow workflow = null;
        for (Workflow w : workflows){
            List<Tarefa> tarefas= w.obterTarefas();
            for (Tarefa t : tarefas){
                if(t.obterId()==idTarefa){
                    workflow = w;
                }
            }
        }
        Servico servico = workflow.obterServico();
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        Catalogo catalogo = null;
        for (Catalogo c : catalogos){
            Iterable<Servico> servicos = c.servicos();
            for(Servico s : servicos){
                if(s.obterId()==servico.obterId()){
                    catalogo = c;
                }
            }
        }
        CriteriosEspecificacao ce = catalogo.obterCriteriosEspecificacao();
        List<Equipa> equipas = ce.obterEquipas();
        List<Colaborador> colaboradoresDisponiveis = new ArrayList<>();
        for(Equipa e : equipas){
            List<Colaborador> colaboradores = e.colaboradores();
            for(Colaborador c : colaboradores){
                colaboradoresDisponiveis.add(c);
            }
        }
        return colaboradoresDisponiveis;
    }

    public void enviarEmail(Colaborador c){
        String subject = "Atribuição de tarefas";
        String body = String.format("Aconselhámos que faça uma consulta as suas tarefas, umas vez que lhe foi atribuída uma nova!");
        SendEmail.sendEmail(c.obterEmail().obterEmail(), subject, body);
    }

    /*public List<Colaborador> colaboradoresAtravesTarefa(int idTarefa){
        Workflow w=colaboradorRepository.workflowAtravesTarefa(idTarefa);
        Servico s=colaboradorRepository.servicoAtravesWorkflow(w);
        Catalogo c=colaboradorRepository.catalogoAtravesServico(s);
        CriteriosEspecificacao ce=colaboradorRepository.criteriosEspecificacaoAtravesCatalogo(c);
        List<Equipa> equipas=colaboradorRepository.equipasAtravesCriteriosEspecificacao(ce);

        List<Colaborador> colaboradoresFinal=new ArrayList<>();
        List<Colaborador> colaboradores=new ArrayList<>();

        for(Equipa e : equipas){
            colaboradores=colaboradorRepository.colaboradoresAtravesEquipa(e);
            if(!colaboradores.isEmpty()) {
                for (Colaborador col : colaboradores) {
                    colaboradoresFinal.add(col);
                }
            }
        }
        return colaboradoresFinal;
    }*/

}
