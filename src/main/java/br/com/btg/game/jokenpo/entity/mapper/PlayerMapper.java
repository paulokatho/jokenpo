package br.com.btg.game.jokenpo.entity.mapper;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.btg.game.jokenpo.entity.PlayerEntity;
import br.com.btg.game.jokenpo.entity.dto.PlayerRequest;
import br.com.btg.game.jokenpo.entity.dto.PlayerResponse;

public class PlayerMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerMapper.class);

    private static ModelMapper MAPPER = new ModelMapper();

    public static PlayerEntity requestToEntity(PlayerRequest playerRequest){
        LOGGER.debug("Converting: request object to entity object");
        return MAPPER.map(playerRequest, PlayerEntity.class);
    }

    public static PlayerResponse entityToResponse(PlayerEntity entity) {
        LOGGER.debug("Converting: entity object to response object");
        return MAPPER.map(entity, PlayerResponse.class);
    }
}
