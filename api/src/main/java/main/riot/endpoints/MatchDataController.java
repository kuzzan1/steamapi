package main.riot.endpoints;

import main.URLBuilder;
import main.riot.domain.match.Match;
import main.riot.domain.match.MatchList;
import main.riot.enums.Locales;
import main.riot.exception.UnsupportedLocaleException;
import main.riot.repositories.MatchListRepository;
import main.riot.repositories.MatchRepository;
import main.steam.bean.RestTemplateBean;
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

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private MatchListRepository matchListRepository;

    @RequestMapping( "/app/lol/{locale}/match/{matchId}" )
    public Match getMatch( @PathVariable( "matchId" ) final Long matchId, @PathVariable final String locale ) throws UnsupportedLocaleException {
        if( Locales.contains( locale ) ) {
            Match match = matchRepository.findByMatchId( matchId );
            if( match == null ) {
                match = getMatchFromApi( matchId, locale );
            }
            else {
                if(match.getTimestamp() + 60000 <= System.currentTimeMillis()) {
                    match = getMatchFromApi( matchId, locale );
                }
            }

            return match;
        }
        return null;

    }


    @RequestMapping( "/app/lol/{locale}/match/summoner/{summonerId}" )
    public MatchList getMatchList( @PathVariable final long summonerId, @PathVariable final String locale ) throws UnsupportedLocaleException {
        if( Locales.contains( locale ) ) {
            MatchList matchList = matchListRepository.findBySummonerId( summonerId );
            if( matchList == null ) {
                matchList = getMatchListFromApi( summonerId, locale );
            } else {
                if(matchList.getTimestamp() + 6000 <= System.currentTimeMillis()) {
                    matchList = getMatchListFromApi( summonerId, locale );
                }
            }
            return matchList;
        }
        return null;
    }

    private MatchList getMatchListFromApi( long summonerId, String locale ) {
        String url = new URLBuilder().baseUrl( "https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v2.2/matchlist/by-summoner" ).Path( String.valueOf( summonerId ) ).buildRiot();
        MatchList matchList = restTemplateBean.exchange( url, MatchList.class );
        matchList.setSummonerId( summonerId );
        matchListRepository.save( matchList );
        return matchList;
    }


    private Match getMatchFromApi( Long matchId, String locale ) {
        String url = new URLBuilder().baseUrl( "https://" + locale + ".api.pvp.net/api/lol/" + locale + "/v2.2/match" ).Path( String.valueOf( matchId ) ).buildRiot();
        Match match = restTemplateBean.exchange( url, Match.class );
        match.setTimestamp( System.currentTimeMillis() );
        matchRepository.save( match );
        return match;
    }

}
