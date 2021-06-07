package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarServicosDeCatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    public List<Servico> listarServicosCatalogo(String titulo){

        Catalogo catalogo=procurarCatalogoTitulo(titulo);

        List<Servico> servicos =catalogo.servicos();

        return servicos;
    }

}
