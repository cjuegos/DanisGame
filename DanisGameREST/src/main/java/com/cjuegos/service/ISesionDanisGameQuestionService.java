package com.cjuegos.service;

import java.util.List;

import com.cjuegos.entities.SesionDanisGameQuestion;

public interface ISesionDanisGameQuestionService extends CrudService<SesionDanisGameQuestion>  {
	
	List<SesionDanisGameQuestion> fetchBySesionAndState(int id, boolean state) throws Exception;

}
