package com.jxy.service;

import org.springframework.security.access.method.P;

import java.sql.SQLException;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 15:49
 * @Description:
 */
public interface IBaseService<E> {
    public void save(E e);

    public E findOneById(Long id);

    public void delete(Long id);

    public void update(E e);
}
