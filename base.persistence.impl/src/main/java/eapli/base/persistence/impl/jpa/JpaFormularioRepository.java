package eapli.base.persistence.impl.jpa;

import eapli.base.formulariomanagement.domain.Formulario;
import eapli.base.formulariomanagement.repository.FormularioRepository;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaFormularioRepository extends BasepaRepositoryBase<Formulario, Integer, Integer> implements DomainRepository<Integer, Formulario>, FormularioRepository {

    public JpaFormularioRepository() {
        super("id");
    }

    @Override
    public Formulario procurarPorNome(final String nome) {
        final TypedQuery<Formulario> query = entityManager().createQuery(
                "SELECT d FROM Formulario d WHERE nome = :NOME",
                Formulario.class);
        query.setParameter("NOME", nome);

        Formulario f=null;

        try{
            f=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return f;
    }
}
