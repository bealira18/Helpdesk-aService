package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;

public class AssociarNivelCriticidadeACatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final NivelCriticidadeRepository nivelCriticidadeRepository = PersistenceContext.repositories().nivelCriticidade();

    public void associarNivelCriticidadeACatalogo(String titulo, String objetivo){
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        Catalogo c = null;
        for (Catalogo c1 : catalogos){
            if(c1.obterTitulo().obterTitulo().equalsIgnoreCase(titulo)){
                c = c1;
            }
        }
        if(c == null){
            throw new IllegalArgumentException("Não existe nenhum catálogo com o título: " + titulo);
        }

        Iterable<NivelCriticidade> niveis = nivelCriticidadeRepository.findAll();
        NivelCriticidade nc = null;
        for (NivelCriticidade n : niveis){
            if(n.obterObjetivo().equalsIgnoreCase(objetivo)){
                nc = n;
            }
        }
        if(nc == null){
            throw new IllegalArgumentException("Não existe nenhum nível de crticidade com o objetivo: " + objetivo);
        }
        associarNivelCriticidadeACatalogo(c, nc);
    }

    public Catalogo associarNivelCriticidadeACatalogo(Catalogo catalogo, NivelCriticidade nivelCriticidade) {

        catalogo.mudarNivelCriticidade(nivelCriticidade);

        return catalogoRepository.save(catalogo);

    }

}