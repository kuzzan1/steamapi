package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.currentgame.CurrentGameInfo;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchList;
import main.riot.domain.match.MatchReference;
import main.riot.domain.summoner.SummonerDto;
import main.riot.domain.summoner.SummonerWithMatches;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

    @RequestMapping("/app/lol/summoner/{summonerName}/matches")
    public Object getPlayerMatchData(@PathVariable final String summonerName) {
        Map<String, LinkedHashMap> summonerByName = summonerDataController.getSummonerByName(summonerName);
        LinkedHashMap summoner = summonerByName.get(summonerName);
        Long summonerId = Long.valueOf((Integer) summoner.get("id"));

        sleep();

        MatchList matchList = matchDataController.getMatchList(summonerId);
        List<Match> deeperMatchList = new ArrayList<>();
        for(int i = 0; i < 7; i++) {
            MatchReference matchReference = matchList.getMatches().get(i);
            sleep();
            deeperMatchList.add(matchDataController.getMatch(matchReference.getMatchId()));
        }
        sleep();

        CurrentGameInfo currentGameInfo = currentGameDataController.getCurrentGameInfo(summonerId);

        return new SummonerWithMatches(summoner, matchList, currentGameInfo, deeperMatchList);
    }


    private void sleep() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
    }
}
