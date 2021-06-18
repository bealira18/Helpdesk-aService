package eapli.base.catalogomanagement.repository;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.repositories.DomainRepository;

public interface CatalogoRepository extends DomainRepository<Integer, Catalogo> {
    Iterable<Catalogo> listarCatalogos();
    Catalogo procurarPorTitulo(Titulo titulo);
    Iterable<Catalogo> listarCatalogosColaborador(Numero numero);
    Catalogo procurarCatalogoPorIdServico(int idServico);
}
