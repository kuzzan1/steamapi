package main.toornament.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-02-03.
 */
public class Opponent {
    @JsonProperty
    private String number;
    @JsonProperty
    private String result;
    @JsonProperty
    private String score;
    @JsonProperty
    private String forfeit;
    @JsonProperty
    private Participant participant;

    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    public String getResult() {
        return result;
    }

    public void setResult( String result ) {
        this.result = result;
    }

    public String getScore() {
        return score;
    }

    public void setScore( String score ) {
        this.score = score;
    }

    public String getForfeit() {
        return forfeit;
    }

    public void setForfeit( String forfeit ) {
        this.forfeit = forfeit;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant( Participant participant ) {
        this.participant = participant;
    }
}
