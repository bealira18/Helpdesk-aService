package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.pedidomanagement.domain.Rascunho;
import eapli.base.pedidomanagement.repository.RascunhoRepository;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddRascunhoBootstrapper implements Action {

    RascunhoRepository repository;

    @Override
    public boolean execute() {

        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        Date d1=new Date();
        Date d2=new Date();
        Date d3=new Date();
        try {
            d1=forma.parse("18/05/2021");
            d2=forma.parse("03/09/2021");
            d3=forma.parse("25/11/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        repository= PersistenceContext.repositories().rascunho();
        Rascunho rascunho1=new Rascunho(d1,"urgente","5",5, 3);
        Rascunho rascunho2=new Rascunho(d2,"urgente","5",5, 4);
        Rascunho rascunho3=new Rascunho(d3,"urgente","5",5, 56);
        repository.save(rascunho1);
        repository.save(rascunho2);
        repository.save(rascunho3);
        return false;
    }

}