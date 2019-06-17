package com.cjuegos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cjuegos.entities.DanisGameQuestion;

@Repository
public interface DanisGameQuestionRepository extends JpaRepository<DanisGameQuestion, Integer>{
	
}
