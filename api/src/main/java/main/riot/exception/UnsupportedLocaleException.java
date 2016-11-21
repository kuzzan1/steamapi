package main.riot.exception;

/**
 * Created by jonas on 2016-11-20.
 */
public class UnsupportedLocaleException extends Exception {

    private String message;

    public UnsupportedLocaleException( String locale ) {
        super();
        message = "Locale is not supported : " + locale;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
