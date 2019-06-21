package com.cjuegos.service;

import java.util.List;

import com.cjuegos.entities.Player;
import com.cjuegos.entities.SesionPlayer;

public interface ISesionPlayerService extends CrudService<SesionPlayer> {
	List<SesionPlayer> fetchBySesion(int id) throws Exception;
	
}
