package com.allobank.allobackendtest.repository;


import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.CalegPage;
import com.allobank.allobackendtest.model.CalegSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CalegCriteriaRepository {
    
    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public CalegCriteriaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Caleg> findAllWithFilters(CalegPage calegPage,
                                             CalegSearchCriteria calegSearchCriteria){
        CriteriaQuery<Caleg> criteriaQuery = criteriaBuilder.createQuery(Caleg.class);
        Root<Caleg> calegRoot = criteriaQuery.from(Caleg.class);
        Predicate predicate = getPredicate(calegSearchCriteria, calegRoot);
        criteriaQuery.where(predicate);
        setOrder(calegPage, criteriaQuery, calegRoot);

        TypedQuery<Caleg> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(calegPage.getPageNumber() * calegPage.getPageSize());
        typedQuery.setMaxResults(calegPage.getPageSize());

        Pageable pageable = getPageable(calegPage);

        long calegsCount = getCalegsCount(predicate);

        return new PageImpl<>(typedQuery.getResultList(), pageable, calegsCount);
    }

    private Predicate getPredicate(CalegSearchCriteria calegSearchCriteria,
                                   Root<Caleg> calegRoot) {
        List<Predicate> predicates = new ArrayList<>();
        if(Objects.nonNull(calegSearchCriteria.getNama())){
            predicates.add(
                    criteriaBuilder.like(calegRoot.get("nama"),
                            "%" + calegSearchCriteria.getNama() + "%")
            );
        }
        if(Objects.nonNull(calegSearchCriteria.getNama())){
            predicates.add(
                    criteriaBuilder.like(calegRoot.get("nama"),
                            "%" + calegSearchCriteria.getNama() + "%")
            );
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    private void setOrder(CalegPage calegPage,
                          CriteriaQuery<Caleg> criteriaQuery,
                          Root<Caleg> calegRoot) {
        if(calegPage.getSortDirection().equals(Sort.Direction.ASC)){
            criteriaQuery.orderBy(criteriaBuilder.asc(calegRoot.get(calegPage.getSortBy())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(calegRoot.get(calegPage.getSortBy())));
        }
    }

    private Pageable getPageable(CalegPage calegPage) {
        Sort sort = Sort.by(calegPage.getSortDirection(), calegPage.getSortBy());
        return PageRequest.of(calegPage.getPageNumber(),calegPage.getPageSize(), sort);
    }

    private long getCalegsCount(Predicate predicate) {
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Caleg> countRoot = countQuery.from(Caleg.class);
        countQuery.select(criteriaBuilder.count(countRoot)).where(predicate);
        return entityManager.createQuery(countQuery).getSingleResult();
    }
}
