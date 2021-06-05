package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarCatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    /*public Catalogo procurarCatalogoPorTitulo(String titulo) {

        Iterable<Catalogo> catalogos = catalogoRepository.findAll();

        Catalogo catalogo = null;

        for (Catalogo c : catalogos) {
            if (c.obterTitulo().obterTitulo().equalsIgnoreCase(titulo)) {
                catalogo = c;
            }
        }
        return catalogo;
    }*/

}