/**  
 * @Title: BaseDao1.java
 * @author zhaosen
 * @date 2015-11-6
 */
package com.fengyang.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.fengyang.util.AddScalar;

/**
 * ClassName: BaseDao1 
 * @Description: TODO
 * @author zhaosen
 * @date 2015-11-6
 */
@SuppressWarnings("unchecked")
public class BaseDao<T>{
	@Autowired
	protected SessionFactory sessionFactory;
	private Class<T> entityClass;

	/** * gerCurrentSession 会自动关闭session，使用的是当前的session事务 * * @return */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/** * openSession 需要手动关闭session 意思是打开一个新的session * * @return */
	public Session getNewSession() {
		return sessionFactory.openSession();
	}
	
	public T load(Serializable id) {
        return (T) getSession().byId(this.entityClass).load(id);
    }

    public T get(Serializable id) {
        return (T) getSession().get(this.entityClass, id);
    }

    public void deleteAll(Collection<?> entities) {
        if(entities != null) {
        	getSession().delete(entities);
        }

    }

    public void realDel(T entity) {
    	getSession().delete(entity);
    }

    public String save(T entity) {
        return getSession().save(entity).toString();
    }

    public void saveOrUpdate(T entity) {
    	getSession().saveOrUpdate(entity);
    }

    public void update(T entity) {
    	getSession().update(entity);
    }

    public List<T> find(String hqlStr) {
    	return getSession().createQuery(hqlStr).list();
    }

    public List<T> find(final String hql, final List<Object> params) {
                Query query = getSession().createQuery(hql);
                if(params != null) {
                    for(int i = 0; i < params.size(); ++i) {
                        query.setParameter(i, params.get(i));
                    }
                }
                return query.list();
    }

    public List<?> getHQLPageList(final String hql, final List<Object> values, final int firstResult, final int maxResults) {
                Query query = getSession().createQuery(hql);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }
                return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    public Integer getHQLCount(final String hql, final List<Object> values) {
                Query query = getSession().createQuery(hql);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }
                return Integer.valueOf(Integer.parseInt(query.uniqueResult().toString()));
    }

    public Object getHQLSum(final String hql, final List<Object> values) {
                Query query = getSession().createQuery(hql);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }
                return query.uniqueResult();
    }

    public List<?> getSQLPageList(final String sql, final List<Object> values, final Class<?> beanClass, final List<String> fieldList, final int firstResult, final int maxResults) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(fieldList != null) {
                    AddScalar.addSclar(query, beanClass, fieldList);
                } else {
                    AddScalar.addSclar(query, beanClass);
                }

                if(beanClass != null) {
                    query.setResultTransformer(Transformers.aliasToBean(beanClass));
                }

                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }

                return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    public List<?> getSQLPageList(final String sql, final List<Object> values, final int firstResult, final int maxResults) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }

                return query.setFirstResult(firstResult).setMaxResults(maxResults).list();
    }

    public Integer getSQLCount(final String sql, final List<Object> values) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }

                return Integer.valueOf(Integer.parseInt(query.uniqueResult().toString()));
    }

    public List<?> findBySQL(final String sql, final List<Object> values, final Class<?> beanClass, final List<String> fieldList) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(fieldList != null) {
                    AddScalar.addSclar(query, beanClass, fieldList);
                } else {
                    AddScalar.addSclar(query, beanClass);
                }

                if(beanClass != null) {
                    query.setResultTransformer(Transformers.aliasToBean(beanClass));
                }

                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }

                return query.list();
    }

    public List<?> findBySQL(final String sql, final List<Object> values) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }
                return query.list();
    }

    public List<?> getHQLList(final String hql, final List<Object> values) {
                Query query = getSession().createQuery(hql);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }

                return query.list();
    }

    public int executeSQL(final String sql, final List<Object> values) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(values != null) {
                    for(int i = 0; i < values.size(); ++i) {
                        query.setParameter(i, values.get(i));
                    }
                }
                return Integer.valueOf(query.executeUpdate());
    }

    public int executeSQL(final String sql, final Object[] values) {
                SQLQuery query = getSession().createSQLQuery(sql);
                query.setCacheable(false);
                if(values != null) {
                    for(int i = 0; i < values.length; ++i) {
                        query.setParameter(i, values[i]);
                    }
                }
                return Integer.valueOf(query.executeUpdate());
}

}
