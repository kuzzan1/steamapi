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
public class StagesService {
    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.toornament.com/v1/tournaments/";

    @RequestMapping("/app/{tournamentId}/stages")
    public String getTournamentStages(@PathVariable("tournamentId") final String tournamentId) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/stages" + ApiKey.getKey()+ "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/{tournamentId}/stages/{number}")
    public String getTournamentStagesByNumber(@PathVariable("tournamentId") final String tournamentId, @PathVariable("number") final String number) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/stages" + number + ApiKey.getKey()+ "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/{tournamentId}/stages/{number}/view")
    public String getTournamentStagesByNumberView(@PathVariable("tournamentId") final String tournamentId, @PathVariable("number") final String number) {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL +"/" + tournamentId + "/stages" + number +"/view" + ApiKey.getKey()+ "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url );
    }
}
