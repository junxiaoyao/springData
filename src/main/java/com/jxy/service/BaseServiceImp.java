package com.jxy.service;

import com.jxy.repository.MySuperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: jxy
 * @Date: 2019/3/8 15:52
 * @Description:
 */
@Service
public class BaseServiceImp<E> implements IBaseService<E> {
    @Autowired
    private MySuperRepository<E, Long> mySuperRepository;

    @Override
    public void save(E e) {
        mySuperRepository.save(e);
    }

    @Override
    public E findOneById(Long id) {
        return mySuperRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        mySuperRepository.delete(id);
    }

    @Override
    public void update(E e) {
        mySuperRepository.update(e);
    }
}
