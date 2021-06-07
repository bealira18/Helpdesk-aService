package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.*;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class EditarCatalogoController {

    private final CatalogoRepository catalogoRepository= PersistenceContext.repositories().catalogo();
    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    public boolean verificarColaborador(int numero){

        if(colaboradorRepository.ofIdentity(new Numero(numero)).isEmpty())
            return false;

        return true;
    }

    public void mudarTitulo(String tituloAtual,String tituloNovo){

        Catalogo catalogo=procurarCatalogoTitulo(tituloAtual);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+tituloAtual);
        }else{
            catalogo.mudarTitulo(new Titulo(tituloNovo));
        }

        catalogoRepository.save(catalogo);
    }

    public void mudarDescricaoBreve(String titulo,String descricaoBreve){

        Catalogo catalogo=procurarCatalogoTitulo(titulo);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+titulo);
        }else{
            catalogo.mudarDescricaoBreve(new DescricaoBreve(descricaoBreve));
        }

        catalogoRepository.save(catalogo);
    }

    public void mudarDescricaoCompleta(String titulo,String descricaoCompleta){

        Catalogo catalogo=procurarCatalogoTitulo(titulo);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+titulo);
        }else{
            catalogo.mudarDescricaoCompleta(new DescricaoCompleta(descricaoCompleta));
        }

        catalogoRepository.save(catalogo);
    }

    public void mudarIcone(String titulo,String icone){

        Catalogo catalogo=procurarCatalogoTitulo(titulo);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+titulo);
        }else{
            catalogo.mudarIcone(new Icone(icone));
        }

        catalogoRepository.save(catalogo);
    }

    public void mudarColaboradorResponsavel(String titulo,int numeroColaborador){

        Catalogo catalogo=procurarCatalogoTitulo(titulo);

        if(!verificarColaborador(numeroColaborador))
            throw new IllegalArgumentException("Colaborador inválido com numero: "+numeroColaborador);

        if(catalogo==null){
            throw new IllegalArgumentException("Catalogo inválido com titulo: "+titulo);
        }else{
            catalogo.mudarColaboradorResponsavel(new Numero(numeroColaborador));
        }

        catalogoRepository.save(catalogo);
    }
}
