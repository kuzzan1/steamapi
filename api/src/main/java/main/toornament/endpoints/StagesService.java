package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.helper.ApiKey;
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
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("stages").Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/{tournamentId}/stages/{number}")
    public String getTournamentStagesByNumber(@PathVariable("tournamentId") final String tournamentId, @PathVariable("number") final String number) {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("stages").Path(number).Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.exchange(url );
    }

    @RequestMapping("/app/{tournamentId}/stages/{number}/view")
    public String getTournamentStagesByNumberView(@PathVariable("tournamentId") final String tournamentId, @PathVariable("number") final String number) {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("stages").Path(number).Path("view").Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.exchange(url );
    }
}
