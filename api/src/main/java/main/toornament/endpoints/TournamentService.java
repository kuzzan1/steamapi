package main.toornament.endpoints;

import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Oauth2;
import main.toornament.security.ApiKey;
import main.toornament.security.OAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2016-01-19.
 */
@RestController
public class TournamentService {

    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;
    private String URL = "https://api.toornament.com/v1/tournaments" + ApiKey.getKey();
    @RequestMapping("/app/tournaments")
    public String getTournaments() {
        Oauth2 oauth2Token = oAuthController.getOauth2Token();
        String url = URL + "&access_token"+oauth2Token.getAccessToken();
        return restTemplateBean.exchange(url);
    }

}
