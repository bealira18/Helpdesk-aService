package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.equipamanagement.domain.Acronimo;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class AssociarEquipaACriteriosEspecificacaoController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository= PersistenceContext.repositories().criteriosEspecificacao();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();


    public void associarEquipaACriteriosEspecificacao(String titulo, String acronimo){

        Catalogo catalogo1=procurarCatalogoTitulo(titulo);

        Equipa equipa1 = procurarEquipaAcronimo(acronimo);

        if(equipa1 == null){
            throw new IllegalArgumentException("Não existe nenhuma equipa com o acrónimo: " + acronimo);
        }

        if(catalogo1 == null){
            throw new IllegalArgumentException("Não existe nenhum catalogo com o título: " + titulo);
        }

        CriteriosEspecificacao ce = catalogo1.obterCriteriosEspecificacao();
        associarEquipaACriteriosEspecificacao(ce, equipa1);
    }

    public CriteriosEspecificacao associarEquipaACriteriosEspecificacao(CriteriosEspecificacao ce, Equipa equipa) {

        ce.addEquipa(equipa);

        return criteriosEspecificacaoRepository.save(ce);

    }

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    public Equipa procurarEquipaAcronimo(String acronimo){
        return equipaRepository.procurarPorAcronimo(new Acronimo(acronimo));
    }

}