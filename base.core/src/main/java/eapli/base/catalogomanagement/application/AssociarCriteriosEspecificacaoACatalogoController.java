package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AssociarCriteriosEspecificacaoACatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository = PersistenceContext.repositories().criteriosEspecificacao();


    public void associarCriteriosEspecificacaoACatalogo(String titulo){

        Catalogo catalogo1 = procurarCatalogoTitulo(titulo);

        if(catalogo1 == null){
            throw new IllegalArgumentException("Não existe nenhum catalogo com o título: " + titulo);
        }

        int idCatalogo = catalogo1.obterId();

        Iterable<CriteriosEspecificacao> criterios = criteriosEspecificacaoRepository.findAll();
        CriteriosEspecificacao ce = null;
        for (CriteriosEspecificacao c : criterios){
            if (c.obterId() == idCatalogo){
                ce = c;
            }
        }

        if(ce == null){
            throw new IllegalArgumentException("Não existe nenhum criterio de especificação com o id: " + idCatalogo);
        }

        associarCriteriosEspecificacaoACatalogo(catalogo1, ce);
    }

    public Catalogo associarCriteriosEspecificacaoACatalogo(Catalogo catalogo, CriteriosEspecificacao criteriosEspecificacao) {

        catalogo.mudarCriteriosEspecificacao(criteriosEspecificacao);

        return catalogoRepository.save(catalogo);

    }

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }
}
