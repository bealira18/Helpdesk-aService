package eapli.base.catalogomanagement.application;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.CriteriosEspecificacao;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.equipamanagement.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servicomanagement.domain.Servico;
import eapli.base.servicomanagement.repository.ServicoRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarCatálogosEServicosController {

    private final CatalogoRepository catalogoRepository = PersistenceContext.repositories().catalogo();
    private final ServicoRepository servicoRepository = PersistenceContext.repositories().servico();
    private final ListarCatalogosEServicosService service = new ListarCatalogosEServicosService();

    public Iterable<Catalogo> listarCatálogos(int numeroColaborador) {

        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        for (Catalogo c : catalogos) {
            CriteriosEspecificacao ce = c.obterCriteriosEspecificacao();
            List<Equipa> equipas = ce.equipas();
            for (Equipa e : equipas) {
                List<Colaborador> colaboradores = e.colaboradores();
                for (Colaborador colab : colaboradores) {
                    if (colab.obterNumero().compararNum(numeroColaborador)) {
                        c.mudarApresentar(true);
                    }
                }
            }
        }
        return service.listarCatalogos();
    }

    public Iterable<Servico> listarServicos() {

        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        for (Catalogo c : catalogos) {
            if (c.obterApresentar() == true) {
                List<Servico> servicos = c.servicos();
                for (Servico s : servicos) {
                    s.mudarApresentar(true);
                }
            }
        }

        return service.listarServicos();
    }

    public void mudarApresentarCatalogosEServicos() {
        Iterable<Catalogo> catalogos = catalogoRepository.findAll();
        for (Catalogo c : catalogos){
            if (c.obterApresentar() == true){
                c.mudarApresentar(false);
            }
        }

        Iterable<Servico> servicos = servicoRepository.findAll();
        for (Servico s : servicos){
            if (s.obterApresentar()==true){
                s.mudarApresentar(false);
            }
        }
    }
}
