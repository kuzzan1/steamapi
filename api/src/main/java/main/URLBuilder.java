package main;

import main.helper.ApiKey;

/**
 * Created by jonas on 2016-02-09.
 */
public class URLBuilder {

    private String url;

    public URLBuilder baseUrl(String url) {
        this.url = url;
        return this;
    }

    public URLBuilder Param(String paramName, Object value) {
        if(paramName != null && value != null) {
            if(this.url.contains("?")) {
                this.url = this.url + "&" + paramName + "=" + value;
            } else {
                this.url = this.url + "?" + paramName + "=" + value;
            }
        }
        return this;
    }

    public String Build() {
        System.out.println("Build URL: " + url);
        return url;
    }

    public URLBuilder Path(String param) {
        this.url = this.url + "/" + param;
        return this;
    }

    public String buildRiot() {
        Param("api_key",ApiKey.getRiotKey());
        //System.out.println("URLBuilder: " + url);
        return url;
    }
}
