package com.cjuegos.service;

import com.cjuegos.entities.Sesion;

public interface ISesionService extends CrudService<Sesion> {

	Sesion findTopByOrderByIdDesc() throws Exception;
}
