package com.empresax.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntityRepository<T> extends JpaRepository<T, Long>{

}