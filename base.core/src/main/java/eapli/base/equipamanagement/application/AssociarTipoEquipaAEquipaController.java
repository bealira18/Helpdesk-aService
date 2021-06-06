package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AssociarTipoEquipaAEquipaController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    private final TipoEquipaRepository tipoEquipaRepository= PersistenceContext.repositories().tipoEquipa();

    public Equipa associarTipoEquipaAEquipa(String acronimoEquipa, String nomeTipoEquipa){

        Equipa e=procurarEquipaAcronimo(acronimoEquipa);
        TipoEquipa t=procurarTipoEquipaNome(nomeTipoEquipa);

        if(e==null)
            throw new IllegalArgumentException("Equipa inválido com acronimo: "+acronimoEquipa);

        if(t==null)
            throw new IllegalArgumentException("Tipo Equipa inválido com nome: "+nomeTipoEquipa);

        e.definirTipoEquipa(t);

        return equipaRepository.save(e);

    }

    public Equipa procurarEquipaAcronimo(String acronimo){
        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }

    public TipoEquipa procurarTipoEquipaNome(String nome){
        return tipoEquipaRepository.procurarPorNome(new Nome(nome));
    }

    /*public Equipa verificarEquipa(String acronimo){

        Iterable<Equipa> equipas=equipaRepository.findAll();

        for(Equipa e : equipas){
            if(e.compareTo(acronimo)==0)
                return e;
        }

        return null;
    }*/

    /*public TipoEquipa verificarTipoEquipa(String nome){

        Iterable<TipoEquipa> tiposEquipa=tipoEquipaRepository.findAll();

        for(TipoEquipa t : tiposEquipa){
            if(t.compareTo(nome)==0)
                return t;
        }

        return null;
    }*/

}
