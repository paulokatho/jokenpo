package br.com.btg.game.jokenpo.entity.dto.api;

import java.sql.Timestamp;

public class Meta {
	
    private Timestamp timestamp;

    public Meta() {}

    public Meta(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
