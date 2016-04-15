package org.cs.Dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by pc on 2016/4/14.
 */
public class BaseDao<T> extends HibernateDaoSupport implements I_BaseDao<T> {

    @Resource(name = "sessionFactory")
    public void getSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
    /*
    * 创建 Class 来获取 泛型<T>
    * */
    private Class<T> clz;

    public Class<T> getClz(){
        if (clz == null){
            clz = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
        }
        return clz;
    }

    @Override
    public void add(T t) {
        this.getSessionFactory().getCurrentSession().save(t);
    }

    @Override
    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    @Override
    public void delete(String id) {
        this.getHibernateTemplate().delete(id);
    }

    @Override
    public T load(String id) {
        return this.getHibernateTemplate().load(getClz() , id);
    }

    @Override
    public List<T> list(String hql, Object[] args) {
        Query query = getSessionFactory().getCurrentSession().createQuery(hql);
        if (args != null){
            for (int i = 0; i < args.length ; i++){
                query.setParameter(i , args[i]);
            }
        }
        List<T> list = query.list();
        return list;
    }

    @Override
    public List<T> list(String hql) {
        return list(hql,null);
    }

    @Override
    public List<T> list(String hql, Object arg) {
        return list(hql,new Object[]{arg});
    }
}
