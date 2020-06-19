package br.com.btg.game.jokenpo.service;

import java.util.List;

import br.com.btg.game.jokenpo.entity.dto.MoveRequest;
import br.com.btg.game.jokenpo.entity.dto.MoveResponse;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

public interface MoveService {

	MoveResponse insert(MoveRequest move) throws JokenpoException;

    List<MoveResponse> getAll() throws JokenpoException;

    List<MoveResponse> deleteByPlayerName(String playerName) throws JokenpoException;

    void clearAll();
}
