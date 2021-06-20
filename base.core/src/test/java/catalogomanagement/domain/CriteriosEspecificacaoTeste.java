package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.equipamanagement.domain.Equipa;

import org.junit.Assert;
import org.junit.Test;

public class CriteriosEspecificacaoTeste {

    @Test
    public void testeAssegurarQueSeAdiconaUmaEquipaALista() {
        CriteriosEspecificacao instanceCriteriosEspecificacao = new CriteriosEspecificacao();
        Equipa instanceEquipa = new Equipa();

        int tamanhoInicialListaEquipas = instanceCriteriosEspecificacao.equipas().size();
        Assert.assertEquals(tamanhoInicialListaEquipas, 0);

        instanceCriteriosEspecificacao.addEquipa(instanceEquipa);

        int tamanhoFinalListaEquipas = instanceCriteriosEspecificacao.equipas().size();
        Assert.assertEquals(tamanhoFinalListaEquipas, 1);
    }

    @Test
    public void testeAssegurarQueSeRemoveUmaEquipaDaLista() {
        CriteriosEspecificacao instanceCriteriosEspecificacao = new CriteriosEspecificacao();
        Equipa instanceEquipa = new Equipa();

        instanceCriteriosEspecificacao.addEquipa(instanceEquipa);

        int tamanhoInicialListaEquipas = instanceCriteriosEspecificacao.equipas().size();
        Assert.assertEquals(tamanhoInicialListaEquipas, 1);

        instanceCriteriosEspecificacao.removerEquipa(instanceEquipa);

        int tamanhoFinalListaEquipas = instanceCriteriosEspecificacao.equipas().size();
        Assert.assertEquals(tamanhoFinalListaEquipas, 0);
    }

}
