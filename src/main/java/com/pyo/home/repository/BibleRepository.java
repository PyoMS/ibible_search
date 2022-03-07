package com.pyo.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pyo.home.DTO.Bible;

@Repository
public interface BibleRepository extends JpaRepository<Bible, String>{

}
