package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.equipamanagement.repository.EquipaRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.Optional;

public class RemoverServicoDeCatalogoController {

    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();

    public void removerServicoDeCatalogo(String tituloCatalogo, String cod){

        Catalogo c1 = procurarCatalogoTitulo(tituloCatalogo);

        Servico s1 = procurarServicoCod(cod);

        if(c1 == null){
            throw new IllegalArgumentException("Não existe nenhum catálogo com o título: " + tituloCatalogo);
        }

        if(s1 == null){
            throw new IllegalArgumentException("Não existe nenhum serviço com o codigo: " + cod);
        }

        removerServicoDeCatalogo(c1, s1);
    }

    public Catalogo removerServicoDeCatalogo(Catalogo catalogo, Servico servico) {

        catalogo.removerServico(servico);

        return catalogoRepository.save(catalogo);

    }

    public Catalogo procurarCatalogoTitulo(String titulo){
        return catalogoRepository.procurarPorTitulo(new Titulo(titulo));
    }

    public Servico procurarServicoCod(String cod){
        return servicoRepository.procurarPorCod(cod);
    }
}