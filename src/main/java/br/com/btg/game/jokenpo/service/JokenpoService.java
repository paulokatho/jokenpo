package br.com.btg.game.jokenpo.service;

import java.util.List;

import br.com.btg.game.jokenpo.entity.dto.JokenpoResponse;
import br.com.btg.game.jokenpo.entity.dto.PlayerResponse;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

public interface JokenpoService {

	List<PlayerResponse> clear() throws JokenpoException;

    JokenpoResponse play() throws JokenpoException;
}
