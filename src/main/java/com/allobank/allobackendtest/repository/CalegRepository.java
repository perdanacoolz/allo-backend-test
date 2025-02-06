package com.allobank.allobackendtest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;

@SuppressWarnings("unused")
@Repository
public interface CalegRepository extends CrudRepository<Caleg, Long> {
 
}
