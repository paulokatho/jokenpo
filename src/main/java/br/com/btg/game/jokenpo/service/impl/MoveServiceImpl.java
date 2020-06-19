package br.com.btg.game.jokenpo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.btg.game.jokenpo.entity.MoveEntity;
import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.entity.dto.MoveRequest;
import br.com.btg.game.jokenpo.entity.dto.MoveResponse;
import br.com.btg.game.jokenpo.entity.mapper.MoveMapper;
import br.com.btg.game.jokenpo.enumeration.EnumException;
import br.com.btg.game.jokenpo.enumeration.EnumMovement;
import br.com.btg.game.jokenpo.repository.MoveRepository;
import br.com.btg.game.jokenpo.repository.PlayerRepository;
import br.com.btg.game.jokenpo.service.MoveService;
import br.com.btg.game.jokenpo.util.MoveSingleton;
import br.com.btg.game.jokenpo.util.exception.JokenpoException;

@Service
public class MoveServiceImpl implements MoveService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MoveServiceImpl.class);

    private MoveRepository moveRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public MoveServiceImpl(MoveRepository moveRepository, PlayerRepository playerRepository){
        this.moveRepository = moveRepository;
        this.playerRepository = playerRepository;
    }

    public MoveResponse insert(MoveRequest move) throws JokenpoException {
        if(Objects.isNull(move)
                || StringUtils.isEmpty(move.getPlayerName())
                || StringUtils.isEmpty(move.getMovement())){
            LOGGER.error("Invalid movement");
            throw new JokenpoException(EnumException.MOVEMENT_INVALID, HttpStatus.NOT_ACCEPTABLE);
        }
        LOGGER.debug("Move : {}", move.toString());

        // identify the player
        PlayerEntity playerEntity = this.playerRepository.findByName(move.getPlayerName());

        // check if exists just one movement for these player
        this.verifyIfAlreadyMoved(playerEntity);

        // identify the movement
        EnumMovement movement = EnumMovement.getEnumMovementByName(move.getMovement());
        if(Objects.isNull(movement)){
            LOGGER.error("Movement not found");
            throw new JokenpoException(EnumException.MOVEMENT_NOT_FOUND, HttpStatus.NOT_FOUND);
        }

        // save entity object
        MoveEntity moveEntity = this.moveRepository.save(new MoveEntity(playerEntity, movement));

        // convert entity to response
        return MoveMapper.entityToResponse(moveEntity);
    }

    public List<MoveResponse> getAll() throws JokenpoException {
        LOGGER.debug("Finding all movements");
        List<MoveEntity> entityList = this.moveRepository.findAll();
        List<MoveResponse> response = new ArrayList<>();
        entityList
                .forEach(elem -> {
                    response.add(MoveMapper.entityToResponse(elem));
                });
        LOGGER.debug("Movements searched");
        return response;
    }

    public List<MoveResponse> deleteByPlayerName(String playerName) throws JokenpoException {
        if(StringUtils.isEmpty(playerName)){
            LOGGER.error("Player name invalid");
            throw new JokenpoException(EnumException.INVALID_PARAM, HttpStatus.NOT_ACCEPTABLE);
        }
        LOGGER.debug("Finding movement by player name : {}", playerName);
        MoveEntity entity = this.moveRepository.findByPlayerName(playerName);
        LOGGER.debug("Deleting movement");
        if(this.moveRepository.delete(entity)){
            return this.getAll();
        };
        LOGGER.error("Error deleting movement");
        throw new JokenpoException(EnumException.MOVEMENT_DELETE_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public void clearAll(){
        MoveSingleton.clear();
    }

    private void verifyIfAlreadyMoved(PlayerEntity player) throws JokenpoException {
        long count = this.moveRepository.findAll()
                .stream()
                .filter(elem ->
                        (elem.getPlayer().getName().compareToIgnoreCase(player.getName()) == 0))
                .count();
        if(count > 0){
            LOGGER.error("Movement already exists for these player");
            throw new JokenpoException(EnumException.MOVEMENT_ALREADY_EXISTS, HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
