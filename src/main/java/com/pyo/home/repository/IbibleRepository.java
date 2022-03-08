package com.pyo.home.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pyo.home.DTO.Bible;

@Repository
public interface IbibleRepository extends JpaRepository<Bible, String>{

}
