package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverCatalogoController {

    private final CatalogoRepository catalogoRepository= PersistenceContext.repositories().catalogo();

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    public void removerCatalogo(String titulo){

        Catalogo catalogo=procurarCatalogoTitulo(titulo);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+titulo);
        }else{
            catalogo.mudarEstado(false);
        }

        catalogoRepository.save(catalogo);
    }

}
