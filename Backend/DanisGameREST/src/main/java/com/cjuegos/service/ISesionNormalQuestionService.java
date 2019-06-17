package com.cjuegos.service;

import java.util.List;

import com.cjuegos.entities.SesionNormalQuestion;

public interface ISesionNormalQuestionService extends CrudService<SesionNormalQuestion>{

	List<SesionNormalQuestion> fetchBySesionAndState(int id, boolean state) throws Exception;
}
