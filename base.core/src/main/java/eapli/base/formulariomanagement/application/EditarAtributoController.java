package eapli.base.formulariomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.DescricaoBreve;
import eapli.base.equipamanagement.domain.Descricao;
import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.ExpressaoRegular;
import eapli.base.formulariomanagement.domain.Nome;
import eapli.base.formulariomanagement.domain.TipoDadosBase;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.nivelcriticidademanagement.domain.Etiqueta;
import eapli.base.servicomanagement.domain.Servico;

public class EditarAtributoController {

    private final AtributoRepository atributoRepository= PersistenceContext.repositories().atributo();

    public Atributo verificarAtributo(String nomeAtributo){

        Iterable<Atributo> atributos=atributoRepository.findAll();

        for(Atributo a : atributos){
            if(a.compareTo(nomeAtributo)==0)
                return a;
        }

        return null;
    }

    public void mudarNome(String nomeAtual,String nomeNovo){

        Atributo atributo=verificarAtributo(nomeAtual);

        if(atributo==null){
            throw new IllegalArgumentException("Atributo inválido com nome: "+nomeAtual);
        }else{
            atributo.mudarNome(nomeNovo);
        }

        verificarCompleto(atributo);

        atributoRepository.save(atributo);
    }

    public void mudarEtiqueta(String nome,String etiqueta){

        Atributo atributo=verificarAtributo(nome);

        if(atributo==null){
            throw new IllegalArgumentException("Atributo inválido com nome: "+nome);
        }else{
            atributo.mudarEtiqueta(etiqueta);
        }

        verificarCompleto(atributo);

        atributoRepository.save(atributo);
    }

    public void mudarDescricao(String nome,String descricao){

        Atributo atributo=verificarAtributo(nome);

        if(atributo==null){
            throw new IllegalArgumentException("Atributo inválido com nome: "+nome);
        }else{
            atributo.mudarDescricao(descricao);
        }

        verificarCompleto(atributo);

        atributoRepository.save(atributo);
    }

    public void mudarExpressaoRegular(String nome,String expressaoRegular){

        Atributo atributo=verificarAtributo(nome);

        if(atributo==null){
            throw new IllegalArgumentException("Atributo inválido com nome: "+nome);
        }else{
            atributo.mudarExpressaoRegular(new ExpressaoRegular(expressaoRegular));
        }

        verificarCompleto(atributo);

        atributoRepository.save(atributo);
    }

    public void mudarTipoDadosBase(String nome,String tipoDadosBase){

        Atributo atributo=verificarAtributo(nome);

        if(atributo==null){
            throw new IllegalArgumentException("Atributo inválido com nome: "+nome);
        }else{
            atributo.mudarTipoDadosBase(new TipoDadosBase(tipoDadosBase));
        }

        verificarCompleto(atributo);

        atributoRepository.save(atributo);
    }

    public void verificarCompleto(Atributo atributo){
        if (!atributo.obterNome().isEmpty() && !atributo.obterEtiqueta().isEmpty() && !atributo.obterDescricao().isEmpty() && !atributo.obterTipoDadosBase().obterTipoDadosBase().isEmpty() && !atributo.obterExpressaoRegular().obterExpressaoRegular().isEmpty()){
            atributo.mudarCompleto(true);
            atributo.mudarAtivo(true);
        }
    }

}
