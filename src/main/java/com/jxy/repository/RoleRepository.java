package com.jxy.repository;

import org.springframework.stereotype.Repository;
import com.jxy.entity.Role;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Repository
public class RoleRepository extends MySuperRepository<Role, Long> {

}
