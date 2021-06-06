package eapli.base.formulariomanagement.repository;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.framework.domain.repositories.DomainRepository;

public interface AtributoRepository extends DomainRepository<Integer, Atributo> {
    Atributo procurarPorNome(String nome);
    Iterable<Atributo> atributosIncompletosFormulario(int idFormulario);
    Iterable<Atributo> atributosCompletosFormulario(int idFormulario);
}
