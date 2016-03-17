package com.custom.dao.custom.impl;

import com.custom.dao.AbstractHibernateDao;
import com.custom.modle.custom.UserAccount;
import org.springframework.stereotype.Repository;

/**
 * Created by robin.tian on 16-3-17.
 */
@Repository
public class UserAccountDaoImpl extends AbstractHibernateDao<UserAccount> implements com.custom.dao.custom.UserAccountDao {

    public UserAccountDaoImpl() {setClazz(UserAccount.class);}
}
