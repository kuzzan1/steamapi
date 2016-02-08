package main.steam.api.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import main.steam.bean.RestTemplateBean;
import main.steam.bean.SteamApiKey;

/**
 * Created by jonas on 2016-01-16.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8000")

public class DotaService {
    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.steampowered.com/IDOTA2Match_205790/";

    @RequestMapping("/app/getDota2/leagues")
    public String getIDota2Match() {
        String url = URL + "GetLeagueListing/v1" + SteamApiKey.getApiKey();
        return restTemplateBean.exchange(url);
    }
    @RequestMapping("/app/getDota2/live/league/{leagueId}/match/{matchId}")
    public String getDota2liveLeagueGames(@RequestParam final String leagueId, @RequestParam final String matchId) {
        String url = URL + "GetLiveLeagueGames/v1" +SteamApiKey.getApiKey() + "&league_id=" + leagueId + "&match_id=" + matchId;
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/live/league/{leagueId}/games")
    public String getDota2liveLeagueGamesLeagueId(@RequestParam final String leagueId) {
        String url = URL + "GetLiveLeagueGames/v1" +SteamApiKey.getApiKey() + "&league_id=" + leagueId;
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/live/league/games/{matchId}")
    public String getDota2liveLeagueGamesMatchId(@RequestParam final String matchId) {
        String url = URL + "GetLiveLeagueGames/v1" +SteamApiKey.getApiKey() + "&match_id=" + matchId;
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/live/league/games")
    public String getDota2liveLeagueGamesAll() {
        String url = URL + "GetLiveLeagueGames/v1" +SteamApiKey.getApiKey();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/match/details/{matchId}")
    public String getDota2MatchDetails(@RequestParam final String matchId) {
        String url = URL + "GetMatchDetails/v1" +SteamApiKey.getApiKey() + "&match_id=" + matchId;
        return restTemplateBean.exchange(url );
    }
/*
                                ===PARAMS===
    hero_id	uint32		The ID of the hero that must be in the matches being queried
    game_mode	uint32		Which game mode to return matches for
    skill	uint32		The average skill range of the match, these can be [1-3] with lower numbers being lower skill. Ignored if an account ID is specified
    min_players	string		Minimum number of human players that must be in a match for it to be returned
    account_id	string		An account ID to get matches from. This will fail if the user has their match history hidden
    league_id	string		The league ID to return games from
    start_at_match_id	uint64		The minimum match ID to start from
    matches_requested	string		The number of requested matches to return
    tournament_games_only	string		Whether or not tournament games should only be returned
    */

    @RequestMapping("/app/getDota2/match/history")
    public String getDota2MatchHistory(@RequestParam final String matchId) {
        String url = URL + "GetMatchHistory/v1" +SteamApiKey.getApiKey() + "&match_id=" + matchId;
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/scheduled/league")
    public String getScheduledLeagueGames() {
        String url = URL + "GetScheduledLeagueGames/v1" +SteamApiKey.getApiKey();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/teams/}")
    public String getDota2Teams() {
        String url = URL + "GetTeamInfoByTeamID/v1" +SteamApiKey.getApiKey();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/getDota2/top/live/game/{partnerId}")
    public String getTopLiveGame(@RequestParam final String partnerId) {
        String url = URL + "GetTopLiveGame/v1" +SteamApiKey.getApiKey() + "&partner=" + partnerId;
        return restTemplateBean.exchange(url );
    }
}
