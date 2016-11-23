package main.riot.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import main.riot.enums.Locales;

/**
 * Created by jonas on 2016-11-21.
 */
public class Error {

    @JsonProperty
    private String errorMessage;
    @JsonProperty
    private Locales[] supportedLocales;

    public Error( String message ) {
        this.errorMessage = message;
        this.supportedLocales = Locales.values();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage( String errorMessage ) {
        this.errorMessage = errorMessage;
    }
}
