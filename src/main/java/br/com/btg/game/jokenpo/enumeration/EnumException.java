package br.com.btg.game.jokenpo.enumeration;

import java.util.Arrays;

public enum EnumException {

    // ERROR-1000
    MOVEMENT_NOT_FOUND("ERROR-1001", "JOKENPO", "MOVEMENT", "NOT FOUND", "Movement not found"),
    MOVEMENT_ALREADY_EXISTS("ERROR-1002", "JOKENPO", "MOVEMENT", "ALREADY EXISTS", "This player has played before"),
    MOVEMENT_INVALID("ERROR-1003", "JOKENPO", "MOVEMENT", "INVALID", "Invalid movement"),
    MOVEMENT_SAVE_ERROR("ERROR-1004", "JOKENPO", "MOVEMENT", "SAVE", "Error saving"),
    MOVEMENT_DELETE_ERROR("ERROR-1005", "JOKENPO", "MOVEMENT", "SAVE", "Error deleting"),
    MOVEMENT_FIND_ALL_ERROR("ERROR-1006", "JOKENPO", "MOVEMENT", "FIND ALL", "Error locating movements"),
    
    // ERROR-2000
    NOBODY_PLAYING("ERROR-2001", "JOKENPO", "PLAY", "NOBODY", "There's no one playing"),
    INSUFFICIENT_PLAYERS("ERROR-2002", "JOKENPO", "PLAY", "INSUFFICIENT PLAYERS", "Insufficient number of players"),
    INSUFFICIENT_MOVEMENTS("ERROR-2003", "JOKENPO", "PLAY", "INSUFFICIENT MOVEMENTS", "Number of movements still insufficient"),
    PLAYERS_PENDING("ERROR", "JOKENPO-2004", "PLAY", "PLAYERS PENDING", "There are players who have not yet chosen"),

    //ERROR-3000
    GENERIC_ERROR("ERROR-3001", "JOKENPO", "GENERIC ERROR", "GENERIC ERROR", "Generic error"),
    INVALID_PARAM("ERROR-3002", "JOKENPO", "PARAM", "INVALID", "Invalid parameter"),
    PLAYER_NOT_FOUND("ERROR-3003", "JOKENPO", "PLAYER", "NOT FOUND", "Player not found"),
    PLAYER_ALREADY_EXISTS("ERROR-3004", "JOKENPO", "PLAYER", "ALREADY EXISTS", "Player already registered"),
    PLAYER_INVALID_NAME("ERROR-3005", "JOKENPO", "PLAYER", "NAME", "Invalid player name"),
    PLAYER_SAVE_ERROR("ERROR-3006", "JOKENPO", "PLAYER", "SAVE", "Error saving the player"),
    PLAYER_DELETE_ERROR("ERROR-3007", "JOKENPO", "PLAYER", "SAVE", "Error deleting the player"),
    PLAYER_FIND_ALL_ERROR("ERROR-3008", "JOKENPO", "PLAYER", "FIND ALL", "Error at looking for the players");
    
    private String code;
    private String origin;
    private String type;
    private String subType;
    private String message;

    EnumException(String code, String origin, String type, String subType, String message) {
        this.code = code;
        this.origin = origin;
        this.type = type;
        this.subType = subType;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getOrigin() {
        return origin;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static EnumException getEnumExceptionByCode(String code){
        for (EnumException elem : Arrays.asList(EnumException.values())) {
            if (code.equals(elem.getCode())) {
                return elem;
            }
        }
        return EnumException.GENERIC_ERROR;
    }
}
