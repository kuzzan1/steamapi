package main.riot.endpoints;

import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.match.MatchList;
import main.riot.domain.summoner.SummonerWithMatches;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jonas on 2016-11-20.
 */
@RestController
public class PlayerMatchesDataController {


    @Autowired
    private RestTemplateBean restTemplateBean;

    @Autowired
    private SummonerDataController summonerDataController;

    @Autowired
    private MatchDataController matchDataController;

    @Autowired
    private CurrentGameDataController currentGameDataController;

    @RequestMapping("/app/lol/{locale}/summoner/{summonerName}/matches")
    public Object getPlayerMatchData(@PathVariable final String summonerName, @PathVariable final String locale) throws UnsupportedLocaleException {
        if( Locales.contains( locale )) {
            Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName, locale);
            LinkedHashMap summoner = summonerByName.get(summonerName);
            Long summonerId = Long.valueOf((Integer) summoner.get("id"));

            sleep();

            MatchList matchList = matchDataController.getMatchList(summonerId, locale);

            sleep();

            CurrentGameInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summonerId, locale);

            return new SummonerWithMatches(summoner, matchList, currentGameInfo);
        }
        return null;
    }


    private void sleep() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }
}
