package com.jxy.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 10:28
 * @Description:
 */


@Transactional
@Repository
public class MySuperRepository<T, P extends Serializable> {
    private Class<T> entityClass;
    @PersistenceContext
    private EntityManager entityManager;

    public MySuperRepository() {
        this.entityClass = getTClass();
    }

    public void update(T t) {
        entityManager.persist(entityManager.merge(t));
    }

    public void save(T t) {
        entityManager.persist(t);
    }

    public void delete(P p) {
        T t = entityManager.find(entityClass, p);
        entityManager.remove(t);
    }

    public T findById(P p) {
        T t = entityManager.find(entityClass, p);
        return t;
    }

    protected Class<T> getTClass() {
        //获取直接超类的 Type 实例
        Type superClassType = getClass().getGenericSuperclass();
        try {
            if (superClassType instanceof ParameterizedType) {
                //参数化类型
                ParameterizedType parameterType = (ParameterizedType) superClassType;
                //泛型参数的 Type 对象的数组
                Type[] parameters = parameterType.getActualTypeArguments();
                //返回实体类参数
                return (Class<T>) parameters[0];
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
