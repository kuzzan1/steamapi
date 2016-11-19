package main.riot.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-19.
 */
@RestController
public class LeagueDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/lol/league/summoner/{summonerIds}")
    public Map getLeagueDataBySummoner(@PathVariable final String summonerIds) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.5/league/by-summoner").Path(summonerIds).buildRiot();
        return restTemplateBean.exchange(url, HashMap.class);
    }

    @RequestMapping("/app/lol/league/summoner/{summonerIds}/entry")
    public Map getLeagueEntryDataBySummoner(@PathVariable final String summonerIds) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.5/league/by-summoner").Path(summonerIds).Path("entry").buildRiot();
        return restTemplateBean.exchange(url, HashMap.class);
    }

    @RequestMapping("/app/lol/league/team/{teamIds}")
    public Map getLeagueDataByTeam(@PathVariable final String teamIds) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.5/league/by-team").Path(teamIds).buildRiot();
        return restTemplateBean.exchange(url, HashMap.class);
    }

    @RequestMapping("/app/lol/league/team/{teamIds}/entry")
    public Map getLeagueEntryDataByTeam(@PathVariable final String teamIds) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.5/league/by-team").Path(teamIds).Path("entry").buildRiot();
        return restTemplateBean.exchange(url, HashMap.class);
    }

    @RequestMapping("/app/lol/league/challenger")
    public Map getChallengerData() {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.5/league/challenger").Param("type", "RANKED_FLEX_SR").buildRiot();
        return restTemplateBean.exchange(url, HashMap.class);
    }

    @RequestMapping("/app/lol/league/master")
    public Map getMasterData() {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.5/league/master").Param("type", "RANKED_FLEX_SR").buildRiot();
        return restTemplateBean.exchange(url, HashMap.class);
    }
}
