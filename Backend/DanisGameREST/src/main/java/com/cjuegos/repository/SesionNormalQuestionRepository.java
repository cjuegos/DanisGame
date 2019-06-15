package com.cjuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjuegos.entities.SesionNormalQuestion;

@Repository
public interface SesionNormalQuestionRepository extends JpaRepository<SesionNormalQuestion, Integer> {

	@Query("select c from SesionNormalQuestion c where c.sesionId.id =?1 and c.state = ?2")
	List<SesionNormalQuestion> fetchBySesionAndState(int id, boolean state);
	
}
