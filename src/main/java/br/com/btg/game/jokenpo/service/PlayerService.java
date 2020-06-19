package br.com.btg.game.jokenpo.service;

import java.util.List;

import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.entity.dto.PlayerRequest;
import br.com.btg.game.jokenpo.entity.dto.PlayerResponse;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

public interface PlayerService {
	
    PlayerResponse insert(PlayerRequest player) throws JokenpoException;

    List<PlayerResponse> getAll() throws JokenpoException;

    PlayerEntity getEntityByName(String name) throws JokenpoException;

    List<PlayerResponse> deleteByName(String name) throws JokenpoException;

    void clearAll();
}
