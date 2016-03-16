package com.custom.dao;

import com.custom.common.IOperations;
import com.google.common.base.Preconditions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by robin.tian on 16-3-15.
 */
public abstract class AbstractHibernateDao<T extends Serializable> implements IOperations<T> {

    private Logger logger = LogManager.getLogger(AbstractHibernateDao.class);

    private Class<T> clazz;


    @PersistenceContext
    private EntityManager em;

    protected final void setClazz(Class<T> clazz) {
        logger.debug(">>> set {} Clazz",clazz);
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
        logger.debug(">>> find Object id is {}",id);
        return em.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public void create(T entity) {
        logger.debug(">>> persist Object in Database: {} ",entity);
        em.persist(entity);
    }

    @Override
    public T update(T entity) {
        logger.debug(">>>merage Object in Database: {} ",entity);
        return em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        logger.debug(">>> detach Object in Database: {} ",entity);
        em.detach(entity);
    }

    @Override
    public void deleteById(long entityId) {
        logger.debug(">>> detach Object By ID entityId: {} ",entityId);
        final T entity = this.findOne(entityId);
        em.detach(entity);
    }
}
