package eapli.base.tarefamanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.domain.EstadoTarefa;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.base.tarefamanagement.repository.InfoTarefaRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TarefasTCPController {

    private final InfoTarefaRepository infoTarefaRepository = PersistenceContext.repositories().infoTarefa();

    public int numTarefasPendentesDoColab(int numColab) {
        int contador = 0;
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        } else {
            for (InfoTarefa infoTarefa : listaInfoTarefas) {
                if (infoTarefa.obterEstado().compareTo(EstadoTarefa.ATRIBUIDA) == 0) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public int numTarefasDpsPrazo(int numColab) {
        int contador = 0;
        int diferença = 0;
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        Date dataHoje = new Date(System.currentTimeMillis());
        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        }else{
            for (InfoTarefa infoTarefa : listaInfoTarefas) {
                if (((dataHoje.getTime() - infoTarefa.obterDataLimite().getTime()) / 86400000) > 0) {
                    contador++;
                }
            }
        }


        return contador;
    }

    public int numTarefasTerminamEmMenos1Dia(int numColab) {
        //1Dia = 24h
        int contador = 0;
        int diferença = 0;
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        Date dataHoje = new Date(System.currentTimeMillis());
        if (listaInfoTarefas == null) {
            throw new IllegalArgumentException("ERRO: Lista de info tarefas é nula!");
        }else{
            for (InfoTarefa infoTarefa : listaInfoTarefas) {
                if (((dataHoje.getTime() - infoTarefa.obterDataLimite().getTime()) / 86400000) == 0 ) {
                    contador++;
                }
            }
        }


        return contador;
    }

    public List<InfoTarefa> listaTarefasUrgenciaCriticidade(int numColab) {
        Iterable<InfoTarefa> listaInfoTarefas = infoTarefaRepository.filtarInfoTarefaporIdDoColaborador(numColab);
        List<InfoTarefa> listaOrdenada = new ArrayList<>();

        for (InfoTarefa infoTarefa : listaInfoTarefas) {

        }

        return listaOrdenada;
    }
}
