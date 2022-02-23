package org.acme.hibernate.orm.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FruitRepository implements PanacheRepository<Fruit> {

    private final EntityManager entityManager;

    public FruitRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public List<Fruit> nativeQuery() {
        return entityManager.createNativeQuery("select * from fruits where name = 'test'", Fruit.class).getResultList();
    }
}
