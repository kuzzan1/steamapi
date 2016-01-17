package steam.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import steam.bean.RestTemplateBean;
import steam.bean.SteamApiKey;

/**
 * Created by jonas on 2016-01-17.
 */
@RestController
@CrossOrigin(origins = "http://localhost:8000")
public class SteamUserService {
    @Autowired
    RestTemplateBean restTemplate;

    private String URL = "https://api.steampowered.com/ISteamUserStats/";

    @RequestMapping("/app/{id}/stat")
    public @ResponseBody
    String GetGlobalStatsForGame  (@PathVariable("id") final String appId) throws Exception{
        String innerUrl = URL + "GetGlobalStatsForGame/v1" + SteamApiKey.getApiKey() + "&appid=" + appId + "&count=10&";
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                String.class).getBody();
    }

    @RequestMapping("/app/{id}/stat/{steamId}")
    public @ResponseBody
    String GetUserStatsForGame  (@PathVariable("id") final String appId, @PathVariable("steamId") final String steamId) throws Exception{
        String innerUrl = URL + "GetUserStatsForGame/v2" + SteamApiKey.getApiKey() + "&appid=" + appId + "&steamid="+steamId;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                String.class).getBody();
    }

    @RequestMapping("/app/{gameid}/achievement")
    public @ResponseBody
    String GetGlobalAchievementPercentagesForApp  (@PathVariable("gameid") final String gameid) throws Exception{
        String innerUrl = URL + "GetGlobalAchievementPercentagesForApp/v2/" + SteamApiKey.getApiKey() + "&gameid=" + gameid;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                String.class).getBody();
    }

    @RequestMapping("/app/{appid}/number/players")
    public @ResponseBody
    String GetNumberOfCurrentPlayers  (@PathVariable("appid") final String appid) throws Exception{
        String innerUrl = URL + "GetNumberOfCurrentPlayers/v1/" + SteamApiKey.getApiKey() + "&appid=" + appid;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                String.class).getBody();
    }

    @RequestMapping("/app/{appid}/achievement/{steamid}")
    public @ResponseBody
    String GetNumberOfCurrentPlayers  (@PathVariable("appid") final String appid, @PathVariable("steamid") final String steamid) throws Exception{
        String innerUrl = URL + "GetPlayerAchievements/v1/" + SteamApiKey.getApiKey() + "&appid=" + appid + "&steamid=" +steamid;
        return restTemplate.getObject().exchange(innerUrl, HttpMethod.GET, null,
                String.class).getBody();
    }
}
