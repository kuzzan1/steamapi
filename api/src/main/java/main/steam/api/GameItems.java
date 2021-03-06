package main.steam.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by jonas on 2016-01-13.
 */

@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class GameItems {

    HashMap<String, String> cached = new HashMap<>();

    @Autowired
    RestTemplateBean restTemplate;

    @RequestMapping("/app/games")
    public @ResponseBody String GetAppList() throws Exception {
        if(cached.get("ISteamApps") == null) {
            cached.put("ISteamApps", restTemplate.getObject().exchange(
                    "https://api.steampowered.com/ISteamApps/GetAppList/v1", HttpMethod.GET, null,
                    String.class).getBody());
        }
        return cached.get("ISteamApps");
    }
}
