package com.cjuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjuegos.entities.SesionDanisGameQuestion;

@Repository
public interface SesionDanisGameQuestionRepository extends JpaRepository<SesionDanisGameQuestion, Integer> {
	
	@Query("select c from SesionDanisGameQuestion c where c.sesionId.id =?1 and c.state = ?2")
	List<SesionDanisGameQuestion> fetchBySesionAndState(int id, boolean state);
	
}
