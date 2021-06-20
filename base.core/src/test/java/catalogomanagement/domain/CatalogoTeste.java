package catalogomanagement.domain;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.servicomanagement.domain.Servico;
import org.junit.Assert;
import org.junit.Test;

public class CatalogoTeste {

    @Test(expected = IllegalArgumentException.class)
    public void testeCatalogoNaoPodeTerTodosOsParametrosNull() {
        Catalogo instance = new Catalogo(null, null, null, 0, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testeCatalogoNaoPodeTerUmNull() {
        Catalogo instance = new Catalogo("idk", "descricaoBreve", null, 8, "icone.jpg");
    }

    @Test
    public void testeConfirmarSeServivoFoiAdicionado() {
        Catalogo instanceCatalogo = new Catalogo();
        Servico instanceServico = new Servico();

        int tamanhoInicialListaServicos = instanceCatalogo.servicos().size();
        Assert.assertEquals(tamanhoInicialListaServicos, 0);

        instanceCatalogo.addServico(instanceServico);

        int tamanhoFinalListaServicos = instanceCatalogo.servicos().size();
        Assert.assertEquals(tamanhoFinalListaServicos, 1);
    }

    @Test
    public void testeConfirmarSeServivoFoiRemovido() {
        Catalogo instanceCatalogo = new Catalogo();
        Servico instanceServico = new Servico();

        instanceCatalogo.addServico(instanceServico);

        int tamanhoInicialListaServicos = instanceCatalogo.servicos().size();
        Assert.assertEquals(tamanhoInicialListaServicos, 1);

        instanceCatalogo.removerServico(instanceServico);

        int tamanhoFinalListaServicos = instanceCatalogo.servicos().size();
        Assert.assertEquals(tamanhoFinalListaServicos, 0);
    }
}
