package main.steam.api.games;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import main.steam.bean.RestTemplateBean;
import main.steam.bean.SteamApiKey;

/**
 * Created by jonas on 2016-01-16.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class CSGoService {

    @Autowired
    private RestTemplateBean restTemplateBean;

    private static String URL = "https://api.steampowered.com/ICSGOServers_730/";


    @RequestMapping("/app/cs/game/servers")
    public String getCSGameServers() {
        String url = URL + "GetGameServersStatus/v1" + SteamApiKey.getApiKey();
        return restTemplateBean.exchange(url);
    }

}
