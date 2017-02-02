package main.twitch.rest;

import main.helper.ApiKey;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jonas on 2017-02-02.
 */
@RestController
public class TwitchDataController {

    @Autowired
    private RestTemplateBean restTemplateBean;

    @RequestMapping("/app/twitch/streams")
    public String getHighLightStreams() {
        String url = "https://api.twitch.tv/kraken/streams?game=League of Legends&client_id="+ ApiKey.getTwitchKey();
        return restTemplateBean.exchange( url );
    }
}
