package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchList;
import main.steam.bean.RestTemplateBean;
import main.helper.ApiKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-11-16.
 */
@RestController
public class MatchDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;


   @RequestMapping("/app/lol/match/{matchId}")
    public Match getMatch( @PathVariable("matchId") final String matchId) {
       String url = new URLBuilder().baseUrl( "https://eune.api.pvp.net/api/lol/eune/v2.2/match" ).Path( matchId ).Param( "api_key", ApiKey.getRiotKey() ).Build();
       return restTemplateBean.exchange(url, Match.class);
   }

    @RequestMapping("/app/lol/match/summoner/{summonerId}")
    public MatchList getMatchList(@PathVariable final String summonerId) {
        String url = new URLBuilder().baseUrl("https://eune.api.pvp.net/api/lol/eune/v2.2/matchlist/by-summoner").Path(summonerId).buildRiot();
        return restTemplateBean.exchange(url, MatchList.class);
    }

}
