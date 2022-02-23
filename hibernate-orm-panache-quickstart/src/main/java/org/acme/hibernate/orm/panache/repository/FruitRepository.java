package org.acme.hibernate.orm.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    private final EntityManager entityManager;

    public FruitRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Fruit> nativeQuery() {
        return entityManager.createNativeQuery("select * from fruit where name = 'Apple'", Fruit.class).getResultList();
    }
}
