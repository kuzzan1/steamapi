package main.toornament.endpoints;

import main.steam.bean.RestTemplateBean;
import main.toornament.security.domain.Oauth2;
import main.toornament.security.ApiKey;
import main.toornament.security.OAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blagan on 2016-01-23.
 */
@RestController
public class GameService {

    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.toornament.com/v1/tournaments/";


    @RequestMapping("/app/{tournamentId}/match/{matchId}/games")
    public String getGameInformation(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches/" + matchId + "/games" + ApiKey.getKey()+ "1&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}/games/{number}")
    public String getGameInformationByNumber(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId, @PathVariable("number") final String number) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches/" + matchId + "/games/" +number + ApiKey.getKey()+ "1&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }

    @RequestMapping("/app/{tournamentId}/match/{matchId}/games/{number}/result")
    public String getGameResultByNumber(@PathVariable("tournamentId") final String tournamentId, @PathVariable("matchId") final String matchId, @PathVariable("number") final String number) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/matches/" + matchId + "/games/" +number +"/result" + ApiKey.getKey()+ "1&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }

}
