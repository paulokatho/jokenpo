package br.com.btg.game.jokenpo.entity.dto;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerRequest {

	@JsonProperty(value = "playerName")
	@NotNull//(message = "Player name is required")
	@NotBlank(message = "Player name cant not blank")
	@Size(min = 3, max = 50)
    private String name;

    public PlayerRequest(){
    }

    public PlayerRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRequest that = (PlayerRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
