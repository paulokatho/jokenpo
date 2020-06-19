package br.com.btg.game.jokenpo.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.btg.game.jokenpo.entity.MoveEntity;
import br.com.btg.game.jokenpo.enumeration.EnumException;
import br.com.btg.game.jokenpo.util.MoveSingleton;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

@Repository
@NoRepositoryBean
public class MoveRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoveRepository.class);

    public MoveEntity save(MoveEntity entity) throws JokenpoException {
        if(MoveSingleton.getInstance() != null
                && MoveSingleton.getInstance().add(entity))
            return entity;
        LOGGER.error("Error saving");
        throw new JokenpoException(EnumException.MOVEMENT_SAVE_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public boolean delete(MoveEntity entity) throws JokenpoException {
        if(MoveSingleton.getInstance() == null) {
            LOGGER.error("Error deleting");
            throw new JokenpoException(EnumException.MOVEMENT_DELETE_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
        }
        return MoveSingleton.getInstance().remove(entity);
    }

    public List<MoveEntity> findAll() throws JokenpoException {
        if(MoveSingleton.getInstance() == null) {
            LOGGER.error("Error finding all movements");
            throw new JokenpoException(EnumException.MOVEMENT_FIND_ALL_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
        }
        return MoveSingleton.getInstance();
    }

    public MoveEntity findByPlayerName(String playerName) throws JokenpoException {
        List<MoveEntity> list = findAll().stream()
                .filter(elem -> (elem.getPlayer().getName().compareToIgnoreCase(playerName) == 0))
                .collect(Collectors.toList());
        Optional<MoveEntity> opt = list.stream().findFirst();
        if(opt.isPresent()){
            return opt.get();
        }
        LOGGER.error("Player movement not found : {}", playerName);
        throw new JokenpoException(EnumException.MOVEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
