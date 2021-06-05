package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.NivelCriticidade;
import eapli.base.nivelcriticidademanagement.repository.NivelCriticidadeRepository;

public class AssociarNivelCriticidadeACatalogoController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final NivelCriticidadeRepository nivelCriticidadeRepository = PersistenceContext.repositories().nivelCriticidade();

    public void associarNivelCriticidadeACatalogo(String titulo, String objetivo){

        Catalogo c = procurarCatalogoTitulo(titulo);

        if(c == null){
            throw new IllegalArgumentException("Não existe nenhum catálogo com o título: " + titulo);
        }

        NivelCriticidade nc = procurarNivelCriticidadeObjetivo(objetivo);

        if(nc == null){
            throw new IllegalArgumentException("Não existe nenhum nível de crticidade com o objetivo: " + objetivo);
        }
        associarNivelCriticidadeACatalogo(c, nc);
    }

    public Catalogo associarNivelCriticidadeACatalogo(Catalogo catalogo, NivelCriticidade nivelCriticidade) {

        catalogo.mudarNivelCriticidade(nivelCriticidade);

        return catalogoRepository.save(catalogo);

    }

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    public NivelCriticidade procurarNivelCriticidadeObjetivo(String objetivo){
        return nivelCriticidadeRepository.procurarPorObjetivo(objetivo);
    }
}