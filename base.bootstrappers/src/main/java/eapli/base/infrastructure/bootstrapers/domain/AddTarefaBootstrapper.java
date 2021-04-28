package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.tarefamanagement.domain.Tarefa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefamanagement.repository.TarefaRepository;
import eapli.framework.actions.Action;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTarefaBootstrapper implements Action{
    
    TarefaRepository repository;

    @Override
    public boolean execute() {

        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        Date d1=new Date();
        Date d2=new Date();
        Date d3=new Date();
        try {
            d1=forma.parse("23/05/2021");
            d2=forma.parse("17/09/2021");
            d3=forma.parse("05/11/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        repository= PersistenceContext.repositories().tarefa();
        Tarefa tarefa1=new Tarefa(d1,1,1,"idk",2,2);
        Tarefa tarefa2=new Tarefa(d2,2,2,"idrk",1,1);
        Tarefa tarefa3=new Tarefa(d3,3,3,"idkr",2,1);
        repository.save(tarefa1);
        repository.save(tarefa2);
        repository.save(tarefa3);
        return false;
    }
}
