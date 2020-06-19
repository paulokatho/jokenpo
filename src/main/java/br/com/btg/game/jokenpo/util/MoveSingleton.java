package br.com.btg.game.jokenpo.util;

import java.util.ArrayList;
import java.util.List;

import br.com.btg.game.jokenpo.entity.MoveEntity;

public class MoveSingleton {

	private static List<MoveEntity> MOVE_INSTANCE;
    private static String INFO = "Movement Singleton Instance";

    private MoveSingleton(){
    }

    public static List<MoveEntity> getInstance() {
        if(MOVE_INSTANCE == null) {
            MOVE_INSTANCE = new ArrayList<MoveEntity>();
        }
        return MOVE_INSTANCE;
    }

    public static List<MoveEntity> clear(){
        MOVE_INSTANCE = new ArrayList<MoveEntity>();
        return getInstance();
    }

    @SuppressWarnings("static-access")
	public String getInfo() {
        return this.INFO;
    }
}
