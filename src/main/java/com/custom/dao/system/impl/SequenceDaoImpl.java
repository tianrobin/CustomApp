package com.custom.dao.system.impl;

import com.custom.dao.AbstractHibernateDao;
import com.custom.dao.system.SequenceDao;
import com.custom.modle.system.Sequence;
import com.custom.type.SequenceNameEnum;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

/**
 * Created by robin.tian on 16-3-31.
 */
@Repository
public class SequenceDaoImpl extends AbstractHibernateDao<Sequence> implements SequenceDao {

    public SequenceDaoImpl() {
        setClazz(Sequence.class);
    }


    @Override
    public String getNextSequence(SequenceNameEnum name) {
        Query query = getEm().createNamedQuery("{call nextval(:name)}");
        query.setParameter("name",name);
        return query.getSingleResult().toString();
    }
}
