package com.cjuegos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cjuegos.entities.NormalQuestion;

@Repository
public interface NormalQuestionRepository extends JpaRepository<NormalQuestion, Integer> {

}
