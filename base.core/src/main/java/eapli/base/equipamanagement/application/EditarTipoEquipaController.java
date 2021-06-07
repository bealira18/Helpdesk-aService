package eapli.base.equipamanagement.application;

import eapli.base.equipamanagement.domain.Cor;
import eapli.base.equipamanagement.domain.Descricao;
import eapli.base.equipamanagement.domain.TipoEquipa;
import eapli.base.equipamanagement.repository.TipoEquipaRepository;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarTipoEquipaController {

    private final TipoEquipaRepository tipoEquipaRepository= PersistenceContext.repositories().tipoEquipa();

    public TipoEquipa procurarTipoEquipaNome(String nome){
        return tipoEquipaRepository.procurarPorNome(new Nome(nome));
    }

    public void mudarNome(String nomeAtual,String nomeNovo){

        TipoEquipa tipoEquipa=procurarTipoEquipaNome(nomeAtual);

        if(tipoEquipa==null){
            throw new IllegalArgumentException("Tipo de Equipa inválido com nome: "+nomeAtual);
        }else{
            tipoEquipa.mudarNome(new Nome(nomeNovo));
        }

        tipoEquipaRepository.save(tipoEquipa);
    }

    public void mudarDescricao(String nome,String descricao){

        TipoEquipa tipoEquipa=procurarTipoEquipaNome(nome);

        if(tipoEquipa==null){
            throw new IllegalArgumentException("Tipo de Equipa inválido com nome: "+nome);
        }else{
            tipoEquipa.mudarDescricao(new Descricao(descricao));
        }

        tipoEquipaRepository.save(tipoEquipa);
    }

    public void mudarCor(String nome,String cor){

        TipoEquipa tipoEquipa=procurarTipoEquipaNome(nome);

        if(tipoEquipa==null){
            throw new IllegalArgumentException("Tipo de Equipa inválido com nome: "+nome);
        }else{
            tipoEquipa.mudarCor(new Cor(cor));
        }

        tipoEquipaRepository.save(tipoEquipa);
    }

}
