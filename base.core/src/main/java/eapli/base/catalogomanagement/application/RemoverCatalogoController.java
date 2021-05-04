package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverCatalogoController {

    private final CatalogoRepository catalogoRepository= PersistenceContext.repositories().catalogo();

    public Catalogo procurarCatalogoPorTitulo(String titulo){

        Iterable<Catalogo> catalogos=catalogoRepository.findAll();

        Catalogo catalogo=null;

        for(Catalogo c : catalogos){
            if(c.obterTitulo().compareTo(new Titulo(titulo))==0){
                catalogo=c;
            }
        }
        return catalogo;
    }

    public void removerCatalogo(String titulo){

        Catalogo catalogo=procurarCatalogoPorTitulo(titulo);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+titulo);
        }else{
            catalogo.mudarEstado(false);
        }

        catalogoRepository.save(catalogo);
    }

}
