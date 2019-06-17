package com.cjuegos.service;

import com.cjuegos.entities.Player;

public interface IPlayerService extends CrudService<Player> {
	Player findBottomByOrderByQuestionsDesc() throws Exception;
}
