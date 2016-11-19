package main.riot.domain.game;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by jonas on 2016-11-19.
 */
public class GameDto {

    @JsonProperty
    private int championId;
    @JsonProperty
    private long createDate;
    @JsonProperty
    private List<PlayerDto> fellowPlayers;
    @JsonProperty
    private long gameId;
    @JsonProperty
    private String gameMode;
    @JsonProperty
    private String gameType;
    @JsonProperty
    private boolean invalid;
    @JsonProperty
    private int ipEarned;
    @JsonProperty
    private int level;
    @JsonProperty
    private int mapId;
    @JsonProperty
    private int spell1;
    @JsonProperty
    private int spell2;
    @JsonProperty
    private RawStatsDto stats;
    @JsonProperty
    private String subType;
    @JsonProperty
    private int teamId;
}
