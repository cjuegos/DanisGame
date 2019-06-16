package com.cjuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjuegos.entities.SesionPlayer;

@Repository
public interface SesionPlayerRepository extends JpaRepository<SesionPlayer, Integer> {

	@Query("select c from SesionPlayer c where c.sesionId.id =?1")
	List<SesionPlayerRepository> fetchBySesion(int id);
}
