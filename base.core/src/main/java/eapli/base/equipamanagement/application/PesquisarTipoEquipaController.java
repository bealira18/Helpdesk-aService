package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarTipoEquipaController {

    private final TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tipoEquipa();

    public TipoEquipa procurarTipoEquipaPorNome(String nome) {

        Iterable<TipoEquipa> tiposEquipa = tipoEquipaRepository.findAll();

        TipoEquipa tipoEquipa = null;

        for (TipoEquipa te : tiposEquipa) {
            if (te.obterNome().obterNome().equals(nome)) {
                tipoEquipa = te;
            }
        }
        return tipoEquipa;
    }

}