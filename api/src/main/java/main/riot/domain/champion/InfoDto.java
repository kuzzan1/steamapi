package main.riot.domain.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-16.
 */
public class InfoDto {

    @JsonProperty
    private int attack;
    @JsonProperty
    private int defense;
    @JsonProperty
    private int difficulty;
    @JsonProperty
    private int magic;

    public int getAttack() {
        return attack;
    }

    public void setAttack( int attack ) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense( int defense ) {
        this.defense = defense;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty( int difficulty ) {
        this.difficulty = difficulty;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic( int magic ) {
        this.magic = magic;
    }
}
