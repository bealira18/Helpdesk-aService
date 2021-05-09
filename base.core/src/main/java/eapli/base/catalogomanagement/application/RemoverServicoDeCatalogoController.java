package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
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

    public void removerServicoDeCatalogo(String tituloCatalogo, String tituloServico){
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        Catalogo c1 = null;
        for (Catalogo c : catalogos){
            if(c.obterTitulo().obterTitulo().equalsIgnoreCase(tituloCatalogo)){
                c1 = c;
            }
        }
        Iterable<Servico> servicos = servicoRepository.findAll();
        Servico s1 = null;
        for (Servico s : servicos){
            if(s.obterTitulo().equalsIgnoreCase(tituloServico)){
                s1 = s;
            }
        }
        if(c1 == null){
            throw new IllegalArgumentException("Não existe nenhum catálogo com o título: " + tituloCatalogo);
        }

        if(s1 == null){
            throw new IllegalArgumentException("Não existe nenhum serviço com o título: " + tituloServico);
        }

        removerServicoDeCatalogo(c1, s1);
    }

    public Catalogo removerServicoDeCatalogo(Catalogo catalogo, Servico servico) {

        catalogo.removerServico(servico);

        return catalogoRepository.save(catalogo);

    }

}