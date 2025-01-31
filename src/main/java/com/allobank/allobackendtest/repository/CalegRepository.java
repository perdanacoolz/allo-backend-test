package com.allobank.allobackendtest.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.allobank.allobackendtest.model.Caleg;
import com.allobank.allobackendtest.model.Dapil;
import com.allobank.allobackendtest.model.Partai;

@SuppressWarnings("unused")
public interface CalegRepository extends JpaRepository<Caleg, Long> {
  Page<Caleg> findByDapil(boolean published, Pageable pageable);

  Page<Caleg> findByDapilContaining(String namaDapil, Pageable pageable);
  
  List<Dapil> findByPartaiContaining(String namaPartai, Sort sort);

  List<Partai> findByPartai_Containing(String nomorUrut, Sort sort);
}
