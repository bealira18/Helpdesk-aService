package eapli.base.colaboradormanagement.repository;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.framework.domain.repositories.DomainRepository;

public interface ColaboradorRepository extends DomainRepository<Numero, Colaborador> {
    Colaborador procurarPorEmail(Email email);
    Colaborador procurarPorNomeCompleto(String nome);
}
