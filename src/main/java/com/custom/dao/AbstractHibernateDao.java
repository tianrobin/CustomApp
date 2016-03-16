package com.custom.dao;

import com.custom.common.IOperations;
import com.google.common.base.Preconditions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by robin.tian on 16-3-15.
 */
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

    private Class<T> clazz;


    @PersistenceContext
    private EntityManager em;

    protected final void setClazz(Class<T> clazz) {
        this.clazz = Preconditions.checkNotNull(clazz);
    }

    protected final Class<T> getClazz() {
        return clazz;
    }

    protected final EntityManager getEm() {
        return em;
    }

    @Override
    public T findOne(long id) {
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void create(T entity) {
        em.persist(entity);
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.detach(entity);
    }

    @Override
    public void deleteById(long entityId) {
        final T entity = this.findOne(entityId);
        em.detach(entity);
    }
}
