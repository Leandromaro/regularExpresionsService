package com.leandroMaro.models.dao;

import com.leandroMaro.models.entities.RegexEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by leandromaro on 2/1/17.
 */
@Repository
@Transactional
public class RegexDao {
    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.

    @PersistenceContext
    private EntityManager entityManager;

    public void create(RegexEntity regex) {
        entityManager.persist(regex);
        return;
    }

    public void delete(RegexEntity regex) {
        if (entityManager.contains(regex))
            entityManager.remove(regex);
        else
            entityManager.remove(entityManager.merge(regex));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<RegexEntity> getAllUsers() {
        return entityManager.createQuery("from RegexEntity").getResultList();
    }

    public RegexEntity getById(long id) {
        return entityManager.find(RegexEntity.class, id);
    }

    public void update(RegexEntity regex) {
        entityManager.merge(regex);
        return;
    }
}
