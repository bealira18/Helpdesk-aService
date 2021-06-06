package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.Atributo;
import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.AtributoRepository;
import eapli.base.tarefamanagement.domain.InfoTarefa;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaAtributoRepository extends BasepaRepositoryBase<Atributo, Integer, Integer> implements DomainRepository<Integer, Atributo>, AtributoRepository {

    public JpaAtributoRepository() {
        super("id");
    }

    @Override
    public Atributo procurarPorNome(final String nome) {
        final TypedQuery<Atributo> query = entityManager().createQuery(
                "SELECT d FROM Atributo d WHERE nome = :NOME",
                Atributo.class);
        query.setParameter("NOME", nome);

        Atributo a=null;

        try{
            a=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return a;
    }

    @Override
    public Iterable<Atributo> atributosIncompletosFormulario(final int idFormulario) {
        final TypedQuery<Atributo> query = entityManager().createQuery(
                "SELECT a FROM Atributo a WHERE a IN (SELECT aind FROM Formulario f JOIN f.atributos aind WHERE f.id = :FORMULARIOID) AND a.completo=false",
                Atributo.class);
        query.setParameter("FORMULARIOID", idFormulario);

        return query.getResultList();
    }

    //AND a.completo=true

    @Override
    public Iterable<Atributo> atributosCompletosFormulario(final int idFormulario) {
        final TypedQuery<Atributo> query = entityManager().createQuery(
                "SELECT a FROM Atributo a WHERE a IN (SELECT aind FROM Formulario f JOIN f.atributos aind WHERE f.id = :FORMULARIOID) AND a.completo=true",
                Atributo.class);
        query.setParameter("FORMULARIOID", idFormulario);

        return query.getResultList();
    }
}