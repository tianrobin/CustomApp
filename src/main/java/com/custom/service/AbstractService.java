package com.custom.service;

import com.custom.common.IOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robin.tian on 16-3-16.
 */
public abstract class AbstractService<T extends Serializable> implements IOperations<T>{

    private Logger logger = LogManager.getLogger(AbstractService.class);

    protected abstract IOperations<T> getDao();

    @Override
    public T findOne(long id) {
        logger.debug(">>> find Object By id is {}",id);
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(T entity) {
        logger.debug(">>> Create Object The Entity={}",entity);
        getDao().create(entity);
    }

    @Override
    public T update(T entity) {
        logger.debug(">>> Update Object The Entity={}",entity);
        return getDao().update(entity);
    }

    @Override
    public void delete(T entity) {
        logger.debug(">>> Delete Object The Entity={}",entity);
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        logger.debug(">>> Create Object By Id  The id={}",entityId);
        getDao().deleteById(entityId);
    }
}
