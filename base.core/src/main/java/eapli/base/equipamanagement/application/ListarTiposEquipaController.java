package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ListarTiposEquipaController {

    private final TipoEquipaRepository tipoEquipaRepository= PersistenceContext.repositories().tipoEquipa();

    public Iterable<TipoEquipa> listarTiposEquipa(){

        Iterable<TipoEquipa> tiposEquipa = tipoEquipaRepository.findAll();

        if(tiposEquipa==null)
            throw new IllegalArgumentException("Ainda não existem tipos de equipa");

        return tiposEquipa;
    }

}