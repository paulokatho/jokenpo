package br.com.btg.game.jokenpo.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.enumeration.EnumException;
import br.com.btg.game.jokenpo.util.PlayerSingleton;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

@Repository
@NoRepositoryBean
public class PlayerRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerRepository.class);

    public PlayerEntity save(PlayerEntity entity) throws JokenpoException {
        if(PlayerSingleton.getInstance() != null
                && PlayerSingleton.getInstance().add(entity))
            return entity;
        LOGGER.error("Error saving");
        throw new JokenpoException(EnumException.PLAYER_SAVE_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
    }

    public boolean delete(PlayerEntity entity) throws JokenpoException {
        if(PlayerSingleton.getInstance() == null) {
            LOGGER.error("Error deleting");
            throw new JokenpoException(EnumException.PLAYER_DELETE_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
        }
        return PlayerSingleton.getInstance().remove(entity);
    }

    public List<PlayerEntity> findAll() throws JokenpoException {
        if(PlayerSingleton.getInstance() == null) {
            LOGGER.error("Error finding all players");
            throw new JokenpoException(EnumException.PLAYER_FIND_ALL_ERROR, HttpStatus.METHOD_NOT_ALLOWED);
        }
        return PlayerSingleton.getInstance();
    }

    public PlayerEntity findByName(String name) throws JokenpoException {
        List<PlayerEntity> list = findAll().stream()
                .filter(elem -> (elem.getName().compareToIgnoreCase(name) == 0))
                .collect(Collectors.toList());
        Optional<PlayerEntity> opt = list.stream().findFirst();
        if(opt.isPresent()){
            return opt.get();
        }
        LOGGER.info("Player not found : {}", name);
        throw new JokenpoException(EnumException.PLAYER_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
