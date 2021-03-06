package main.toornament.endpoints;

import main.URLBuilder;
import main.steam.bean.RestTemplateBean;
import main.toornament.domain.Participant;
import main.helper.ApiKey;
import main.toornament.security.OAuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Blagan on 2016-01-23.
 */
@RestController
public class ParticipantsService {

    @Autowired
    private OAuthController oAuthController;

    @Autowired
    private RestTemplateBean restTemplateBean;

    private String URL = "https://api.toornament.com/v1/tournaments/";

    @RequestMapping("/app/{tournamentId}/participants")
    public Participant[] getPlayersInTournament(@PathVariable("tournamentId") final String tournamentId) throws Exception {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("participants").Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.getObject().exchange( url, HttpMethod.GET, null, Participant[].class ).getBody();

    }

    @RequestMapping("/app/{tournamentId}/participants/{playerId}")
    public Participant getPlayersInTournament(@PathVariable("tournamentId") final String tournamentId, @PathVariable("playerId") final String playerId) {
        String url = new URLBuilder().baseUrl(URL+tournamentId).Path("participants").Path(playerId).Param("api_key", ApiKey.getToornamentKey()).Build();
        return restTemplateBean.exchange(url , Participant.class);
    }


}
