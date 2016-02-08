package main.toornament.security.domain;

/**
 * Created by jonas on 2016-01-19.
 */
public class Oauth2 {
    private String accessToken;
    private String expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken( String accessToken ) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn( String expiresIn ) {
        this.expiresIn = expiresIn;
    }
}
