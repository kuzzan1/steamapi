package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchList;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
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


   @RequestMapping("/app/lol/{locale}/match/{matchId}")
    public Match getMatch( @PathVariable("matchId") final String matchId, @PathVariable final String locale) throws UnsupportedLocaleException {
       if( Locales.contains(locale)) {
           String url = new URLBuilder().baseUrl( "https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.2/match" ).Path( matchId ).Param( "api_key", ApiKey.getRiotKey() ).Build();
           return restTemplateBean.exchange(url, Match.class);
       }
       return null;

   }

    @RequestMapping("/app/lol/{locale}/match/summoner/{summonerId}")
    public MatchList getMatchList(@PathVariable final long summonerId, @PathVariable final String locale) throws UnsupportedLocaleException {
        if(Locales.contains( locale )) {
            String url = new URLBuilder().baseUrl("https://"+locale+".api.pvp.net/api/lol/"+locale+"/v2.2/matchlist/by-summoner").Path(String.valueOf(summonerId)).buildRiot();
            return restTemplateBean.exchange(url, MatchList.class);
        }
        return null;
    }

}
