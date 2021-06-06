package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarTipoEquipaController {

    private final TipoEquipaRepository tipoEquipaRepository = PersistenceContext.repositories().tipoEquipa();

    public TipoEquipa procurarTipoEquipaPorNome(String nome) {

        return tipoEquipaRepository.procurarPorNome(new Nome(nome));
    }

}