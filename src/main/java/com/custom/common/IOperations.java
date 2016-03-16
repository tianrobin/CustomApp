package com.custom.common;

import java.io.Serializable;
import java.util.List;

/**
 * 通用访问接口
 * Created by robin.tian on 16-3-15.
 */
public interface IOperations<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
