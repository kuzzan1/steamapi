package main.toornament.endpoints;

import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Oauth2;
import main.toornament.security.ApiKey;
import main.toornament.security.OAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/app/{tournamentId}/matches/")
    public String getMatchesInTournament(@PathVariable("tournamentId") final String tournamentId) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches" + ApiKey.getKey()+ "&with_games=1&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}")
    public String getInformationOnMatch(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches/" + matchId + ApiKey.getKey()+ "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}/result")
    public String getMatchResults(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches/" + matchId +"/result"+ ApiKey.getKey()+ "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }



}
