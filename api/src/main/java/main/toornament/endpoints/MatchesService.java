package main.toornament.endpoints;

import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Match;
import main.toornament.security.ApiKey;
import main.toornament.security.OAuthController;
import main.toornament.security.domain.Oauth2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blagan on 2016-01-23.
 */
@RestController
public class MatchesService {
    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.toornament.com/v1/tournaments/";

    @RequestMapping("/app/{tournamentId}/matches")
    public Match[] getMatchesInTournament(@PathVariable("tournamentId") final String tournamentId) throws Exception {
        String url = URL + tournamentId + "/matches" + ApiKey.getKey()+ "&with_games=1";
        System.out.println(url);
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Match[].class ).getBody();
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}")
    public Match getInformationOnMatch(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        String url = URL + tournamentId + "/matches/" + matchId + ApiKey.getKey()+ "&with_games=1";
        System.out.println(url);
        return restTemplateBean.exchange(url ,Match.class);
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}/result")
    public String getMatchResults(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches/" + matchId +"/result"+ ApiKey.getKey()+ "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url );
    }



}