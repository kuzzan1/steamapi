package main.riot.endpoints;

import main.URLBuilder;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
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

    @RequestMapping("/app/lol/{locale}/league/summoner/{summonerIds}")
    public Map<?, ?> getLeagueDataBySummoner(@PathVariable final String summonerIds, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.5/league/by-summoner").Path(summonerIds).buildRiot();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }

    @RequestMapping("/app/lol/{locale}/league/summoner/{summonerIds}/entry")
    public Map<?, ?> getLeagueEntryDataBySummoner(@PathVariable final String summonerIds, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.5/league/by-summoner").Path(summonerIds).Path("entry").buildRiot();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }

    @RequestMapping("/app/lol/{locale}/league/team/{teamIds}")
    public Map<?, ?> getLeagueDataByTeam(@PathVariable final String teamIds, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.5/league/by-team").Path(teamIds).buildRiot();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }

    @RequestMapping("/app/lol/{locale}/league/team/{teamIds}/entry")
    public Map<?, ?> getLeagueEntryDataByTeam(@PathVariable final String teamIds, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.5/league/by-team").Path(teamIds).Path("entry").buildRiot();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }

    @RequestMapping("/app/lol/{locale}/league/challenger")
    public Map<?, ?> getChallengerData(@PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.5/league/challenger").Param("type", "RANKED_FLEX_SR").buildRiot();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }

    @RequestMapping("/app/lol/{locale}/league/master")
    public Map<?, ?> getMasterData(@PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains(locale)) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.5/league/master").Param("type", "RANKED_FLEX_SR").buildRiot();
            return restTemplateBean.exchange(url, HashMap.class);
        }
        return null;
    }
}
