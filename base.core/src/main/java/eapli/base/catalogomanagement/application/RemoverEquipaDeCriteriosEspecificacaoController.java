package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.catalogomanagement.repository.CriteriosEspecificacaoRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class RemoverEquipaDeCriteriosEspecificacaoController {

    private final EquipaRepository equipaRepository = PersistenceContext.repositories().equipa();
    private final CriteriosEspecificacaoRepository criteriosEspecificacaoRepository= PersistenceContext.repositories().criteriosEspecificacao();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();


    public void removerEquipaDeCriteriosEspecificacao(String titulo, String acronimo){
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        Catalogo catalogo1 = null;
        for (Catalogo c : catalogos){
            if(c.obterTitulo().obterTitulo().equalsIgnoreCase(titulo)){
                catalogo1 = c;
            }
        }
        Iterable<Equipa> equipas = equipaRepository.findAll();
        Equipa equipa1 = null;
        for (Equipa e : equipas){
            if(e.acronimo().stringAcronimo().equalsIgnoreCase(acronimo)){
                equipa1 = e;
            }
        }

        if(equipa1 == null){
            throw new IllegalArgumentException("Não existe nenhuma equipa com o acrónimo: " + acronimo);
        }

        if(catalogo1 == null){
            throw new IllegalArgumentException("Não existe nenhum catalogo com o título: " + titulo);
        }

        CriteriosEspecificacao ce = catalogo1.obterCriteriosEspecificacao();
        removerEquipaDeCriteriosEspecificacao(ce, equipa1);
    }

    public CriteriosEspecificacao removerEquipaDeCriteriosEspecificacao(CriteriosEspecificacao ce, Equipa equipa) {

        ce.removerEquipa(equipa);

        return criteriosEspecificacaoRepository.save(ce);

    }

}