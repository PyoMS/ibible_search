package com.pyo.home.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pyo.home.DTO.Bible;

@Repository
public interface IbibleRepository extends JpaRepository<Bible, String>{
	@Query("SELECT b FROM Bible b where b.contents like %:contents%")
	public List<Bible> findAllContents(@Param(value = "contents") String contents) throws Exception;
	
	@Query("SELECT b FROM Bible b where b.contents like %:contents%")
	public List<Bible> findAllContents(@Param(value = "contents") String contents, Sort sort) throws Exception;
}
