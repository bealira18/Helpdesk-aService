package eapli.base.persistence.impl.jpa;

import eapli.base.catalogomanagement.domain.Catalogo;
import eapli.base.catalogomanagement.domain.Titulo;
import eapli.base.catalogomanagement.repository.CatalogoRepository;
import eapli.base.colaboradormanagement.domain.Numero;
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
    public Catalogo procurarPorTitulo(final Titulo titulo) {
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

    @Override
    public Iterable<Catalogo> listarCatalogosColaborador(final Numero num) {
        final TypedQuery<Catalogo> query = entityManager().createQuery(
                "SELECT DISTINCT c FROM Catalogo c, Colaborador col, Equipa e, CriteriosEspecificacao ce WHERE (col.id= :NUMERO AND col IN (SELECT aind FROM e.colaboradores aind WHERE aind.id= :NUMERO) AND e IN (SELECT aind FROM CriteriosEspecificacao ce JOIN ce.equipas aind) AND ce IN c.criteriosEspecificaçao)",
                Catalogo.class);
        query.setParameter("NUMERO", num);

        return query.getResultList();
    }
//"SELECT c FROM Catalogo c, Colaborador col, Equipa e, CriteriosEspecificacao ce WHERE col.id = :NUMERO AND col IN (SELECT aind FROM Equipa e JOIN e.colaboradores aind) AND e IN (SELECT aind FROM CriteriosEspecificacao ce JOIN ce.equipas aind) AND ce IN c.criteriosEspecificaçao",
//"SELECT c FROM Catalogo c, Colaborador col, Equipa e, CriteriosEspecificacao ce WHERE col.id = :NUMERO AND col IN (SELECT aind FROM Equipa e JOIN e.colaboradores aind WHERE e IN (SELECT ainda FROM CriteriosEspecificacao ce JOIN ce.equipas ainda WHERE ce IN c.criteriosEspecificaçao))",
//"SELECT DISTINCT c FROM Catalogo c, Colaborador col, Equipa e, CriteriosEspecificacao ce WHERE col IN (SELECT eq FROM Equipa e JOIN e.colaboradores eq WHERE eq IN (SELECT cri FROM CriteriosEspecificacao ce JOIN ce.equipas cri WHERE cri=c.criteriosEspecificaçao))",
}
