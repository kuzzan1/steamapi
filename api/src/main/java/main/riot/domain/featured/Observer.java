package main.riot.domain.featured;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by jonas on 2016-11-18.
 */
public class Observer {

    @JsonProperty
    private String encryptionKey;

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey( String encryptionKey ) {
        this.encryptionKey = encryptionKey;
    }
}
