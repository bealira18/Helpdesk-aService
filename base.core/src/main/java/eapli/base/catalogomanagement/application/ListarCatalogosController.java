package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class ListarCatalogosController {

    private final CatalogoRepository catalogoRepository= PersistenceContext.repositories().catalogo();

    public Iterable<Catalogo> listarCatalogos(){

        Iterable<Catalogo> catalogos = catalogoRepository.findAll();

        if(catalogos==null)
            throw new IllegalArgumentException("Ainda não existem catálogos");

        return catalogos;
    }

}