package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarTipoEquipaController {

    private final TipoEquipaRepository tipoEquipaRepository= PersistenceContext.repositories().tipoEquipa();

    public TipoEquipa adicionarTipoEquipa(String descricao, String cor){

        final TipoEquipa tipoEquipa=new TipoEquipa(descricao,cor);

        return tipoEquipaRepository.save(tipoEquipa);

    }

}
