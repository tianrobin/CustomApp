package com.custom.service;

import com.custom.common.IOperations;

import java.io.Serializable;
import java.util.List;

/**
 * Created by robin.tian on 16-3-16.
 */
public abstract class AbstractService<T extends Serializable> implements IOperations<T>{

    protected abstract IOperations<T> getDao();

    @Override
    public T findOne(long id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        getDao().deleteById(entityId);
    }
}
