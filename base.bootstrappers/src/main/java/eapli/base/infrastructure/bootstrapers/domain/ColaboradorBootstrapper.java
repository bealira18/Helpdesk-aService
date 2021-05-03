package eapli.base.infrastructure.bootstrapers.domain;

import eapli.base.colaboradormanagement.application.AdicionarColaboradorController;
import eapli.framework.actions.Action;

import java.util.Date;

public class ColaboradorBootstrapper implements Action {

    //ColaboradorRepository repository;

    /*@Override
    public boolean execute() {

        repository= PersistenceContext.repositories().colaborador();
        Colaborador colaborador1=new Colaborador(36,"Bea","Beatriz Lira",new Date(2001/05/18),"Gaia",true,"Ola56789","ui@gmail.com","idk","idk","idk",181823L);
        Colaborador colaborador2=new Colaborador(6,"Ze","José Pereira",new Date(2006/9/03),"Porto",true,"Oi123456","oi@hotmail.com","idk","idk","idk",1815343L);
        Colaborador colaborador3=new Colaborador(8,"Pedro","Pedro Morais",new Date(1998/11/25),"Matosinhos",true,"Ai9qwerty","ai@isep.ipp.pt","idk","idk","idk",180923L);
        repository.save(colaborador1);
        repository.save(colaborador2);
        repository.save(colaborador3);
        return false;
    }*/

    private final AdicionarColaboradorController controller=new AdicionarColaboradorController();

    @Override
    public boolean execute() {

        controller.adicionarColaborador(36,"Bea","Beatriz Lira",new Date(2001/05/18),"Gaia",true,"ui@gmail.com","idk","idk",181823L);
        controller.adicionarColaborador(8,"Pedro","Pedro Morais",new Date(1998/11/25),"Matosinhos",true,"ai@isep.ipp.pt","idk","idk",180923L);

        return true;
    }

}


