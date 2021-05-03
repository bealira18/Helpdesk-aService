package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AdicionarCatalogoController {

    private final CatalogoRepository catalogoRepository= PersistenceContext.repositories().catalogo();
    private final ColaboradorRepository colaboradorRepository= PersistenceContext.repositories().colaborador();

    public Catalogo adicionarCatalogo(String titulo,String descricaoBreve,String descricaoCompleta,int numero, String icone){

        if(!procurarColaboradorPorNumero(numero))
            throw new IllegalArgumentException("Colaborador inválido com numero: "+numero);

        final Catalogo novoCatalogo=new Catalogo(titulo,descricaoBreve,descricaoCompleta,numero,icone);

        return catalogoRepository.save(novoCatalogo);

    }

    public boolean procurarColaboradorPorNumero(int numero){

        if(colaboradorRepository.ofIdentity(new Numero(numero)).isEmpty())
            return false;

        return true;
    }



}
