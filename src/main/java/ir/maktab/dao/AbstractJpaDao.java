package ir.maktab.dao;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

public abstract class AbstractJpaDao<E, I> {

    EntityManager entityManager;

    public AbstractJpaDao(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    public void save(E entity){
        entityManager.persist(entity);
    }

    public void load(I id){
        entityManager.find(getEntityClass(),id);
    }

    public void update(){

    }
    public void delete(E entity){
        entityManager.remove(entity);
    }

    public abstract Class<E> getEntityClass();
}
