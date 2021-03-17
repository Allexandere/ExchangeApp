package io.project.exchangeproject.repository;

import antlr.collections.impl.LList;
import io.project.exchangeproject.model.Valute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ValuteRepository {

    @Autowired
    private EntityManager entityManager;

    public Valute createValute(Valute valute){
        entityManager.persist(valute);
        entityManager.flush();
        return valute;
    }

    public List<String> getValutesCode(){
        List<String> codes = new ArrayList<>();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Valute> query = builder.createQuery(Valute.class);
        Root<Valute> root = query.from(Valute.class);

        query.select(root);

        entityManager.createQuery(query).getResultList().forEach(
                el -> codes.add(String.format("%s(%s)",((Valute) el).getCharCode(), ((Valute) el).getName())));
        codes.remove(0);
        return codes;
    }

    public Valute getValuteByCode(String code){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Valute> query = builder.createQuery(Valute.class);
        Root<Valute> root = query.from(Valute.class);

        query.select(root).where(builder.equal(root.get("CharCode"), code));

        return entityManager.createQuery(query).getResultStream().findFirst().orElse(null);
    }
}
