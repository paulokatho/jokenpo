package br.com.btg.game.jokenpo.entity;

import java.util.Objects;

import javax.persistence.Entity;

import br.com.btg.game.jokenpo.enumeration.EnumMovement;

@Entity
public class MoveEntity {

    private PlayerEntity player;
    private EnumMovement enumMovement;

    public MoveEntity(){
    }

    public MoveEntity(PlayerEntity player, EnumMovement enumMovement) {
        this.player = player;
        this.enumMovement = enumMovement;
    }

    public PlayerEntity getPlayer() {
        return player;
    }

    public void setPlayer(PlayerEntity player) {
        this.player = player;
    }

    public EnumMovement getEnumMovement() {
        return enumMovement;
    }

    public void setEnumMovement(EnumMovement enumMovement) {
        this.enumMovement = enumMovement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MoveEntity that = (MoveEntity) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(enumMovement, that.enumMovement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), player, enumMovement);
    }

    @Override
    public String toString() {
        return "MoveEntity{" +
                "player=" + player +
                ", enumMovement=" + enumMovement +
                '}';
    }

}