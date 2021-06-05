package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.servicomanagement.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class JpaCatalogoRepository extends BasepaRepositoryBase<Catalogo, Integer, Integer> implements DomainRepository<Integer, Catalogo>, CatalogoRepository {

    public JpaCatalogoRepository(){ super("id");}

    @Override
    public Iterable<Catalogo> listarCatalogos() {
        return match("e.apresentar=true");
    }

    @Override
    public Catalogo procurarPorTitulo(final String titulo) {
        final TypedQuery<Catalogo> query = entityManager().createQuery(
                "SELECT d FROM Catalogo d WHERE titulo = :TITULO",
                Catalogo.class);
        query.setParameter("TITULO", titulo);

        Catalogo c=null;

        try{
            c=query.getSingleResult();
        }catch (NoResultException nre){
        }

        return c;
    }
}
