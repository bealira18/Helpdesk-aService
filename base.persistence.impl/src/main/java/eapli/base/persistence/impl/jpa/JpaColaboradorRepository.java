package eapli.base.persistence.impl.jpa;

import eapli.base.colaboradormanagement.domain.Colaborador;
import eapli.base.colaboradormanagement.domain.Email;
import eapli.base.colaboradormanagement.domain.Numero;
import eapli.base.colaboradormanagement.repository.ColaboradorRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaColaboradorRepository extends BasepaRepositoryBase<Colaborador, Integer, Numero> implements DomainRepository<Numero, Colaborador>, ColaboradorRepository {

    public JpaColaboradorRepository(){ super("numero");}

    @Override
    public Colaborador procurarPorEmail(final Email email) {
        final TypedQuery<Colaborador> query = entityManager().createQuery(
                "SELECT d FROM Colaborador d WHERE email = :EMAIL",
                Colaborador.class);
        query.setParameter("EMAIL", email);

        Colaborador c=null;

        try{
            c=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return c;
    }

    @Override
    public Colaborador procurarPorNomeCompleto(final String nomeCompleto) {
        final TypedQuery<Colaborador> query = entityManager().createQuery(
                "SELECT d FROM Colaborador d WHERE nomeCompleto = :NOMECOMPLETO",
                Colaborador.class);
        query.setParameter("NOMECOMPLETO", nomeCompleto);

        Colaborador c=null;

        try{
            c=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return c;
    }
}
