package eapli.base.servicomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarServicosDeCatalogoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    public Catalogo procurarCatalogoPorTitulo(String titulo) {

        Iterable<Catalogo> catalogos = catalogoRepository.findAll();

        Catalogo catalogo = null;

        for (Catalogo c : catalogos) {
            if (c.obterTitulo().obterTitulo().equalsIgnoreCase(titulo)) {
                catalogo = c;
            }
        }
        return catalogo;
    }

    public List<Servico> listarServicosCatalogo(String titulo){

        Iterable<Servico> todosServicos=servicoRepository.findAll();

        List<Servico> retServicos=new ArrayList<>();

        Catalogo catalogo=procurarCatalogoPorTitulo(titulo);

        for(Servico s : todosServicos){
            if(catalogo.servicos().contains(s))
                retServicos.add(s);
        }
        return retServicos;
    }

}
