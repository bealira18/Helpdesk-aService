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

        repository= PersistenceContext.repositories().colaborador();
        Colaborador colaborador1=new Colaborador(36,"Bea","Beatriz Lira",new Date(2001/05/18),"Gaia",true,"Ola56789","ui@gmail.com","idk","idk","idk",181823L);
        Colaborador colaborador2=new Colaborador(6,"Ze","José Pereira",new Date(2006/9/03),"Porto",true,"Oi123456","oi@hotmail.com","idk","idk","idk",1815343L);
        Colaborador colaborador3=new Colaborador(8,"Pedro","Pedro Morais",new Date(1998/11/25),"Matosinhos",true,"Ai9qwerty","ai@isep.ipp.pt","idk","idk","idk",180923L);
        repository.save(colaborador1);
        repository.save(colaborador2);
        repository.save(colaborador3);
        return false;
    }

}
