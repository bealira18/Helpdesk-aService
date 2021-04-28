package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.framework.actions.Action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddColaboradorBootstrapper implements Action {

    ColaboradorRepository repository;

    @Override
    public boolean execute() {
        SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy");
        Date d1=new Date();
        Date d2=new Date();
        Date d3=new Date();
        try {
            d1=forma.parse("18/05/2001");
            d2=forma.parse("03/09/2006");
            d3=forma.parse("25/11/1998");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        repository= PersistenceContext.repositories().colaborador();
        Colaborador colaborador1=new Colaborador(36,"Bea","Beatriz Lira",d1,"Gaia",true,"ola","ui@","idk","idk","idk",181823L);
        Colaborador colaborador2=new Colaborador(6,"Ze","José Pereira",d2,"Porto",true,"oi","oi@","idk","idk","idk",1815343L);
        Colaborador colaborador3=new Colaborador(8,"Pedro","Pedro Morais",d3,"Matosinhos",true,"ai","ai@","idk","idk","idk",180923L);
        repository.save(colaborador1);
        repository.save(colaborador2);
        repository.save(colaborador3);
        return false;
    }

}
