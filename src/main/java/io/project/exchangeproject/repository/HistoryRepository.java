package io.project.exchangeproject.repository;

import io.project.exchangeproject.model.ExchangeRequest;
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
public class HistoryRepository {
    @Autowired
    private EntityManager entityManager;

    public ExchangeRequest createRecord(ExchangeRequest exchangeRequest){
        entityManager.persist(exchangeRequest);
        entityManager.flush();
        return exchangeRequest;
    }

    public List<ExchangeRequest> getRecords(){
        List<ExchangeRequest> history = new ArrayList<>();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ExchangeRequest> query = builder.createQuery(ExchangeRequest.class);
        Root<ExchangeRequest> root = query.from(ExchangeRequest.class);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }
}
