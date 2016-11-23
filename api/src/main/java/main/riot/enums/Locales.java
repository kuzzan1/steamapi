package main.riot.enums;

import main.riot.exception.UnsupportedLocaleException;

/**
 * Created by jonas on 2016-11-20.
 */
public enum Locales {
    BR("BR"),
    EUNE("EUNE"),
    EUW("EUW"),
    JP("JP"),
    KR("KR"),
    LAN("LAN"),
    LAS("LAS"),
    NA("NA"),
    OCE("OCE"),
    RU("RU"),
    TR("TR");

    private String locale;


    Locales( String locale ) {
        this.locale = locale;
    }


    public static boolean contains( String locale ) throws UnsupportedLocaleException {
        for( Locales locales : Locales.values() ) {
            if(locales.locale.equalsIgnoreCase( locale )) {
                return true;
            }
        }
        throw new UnsupportedLocaleException( locale);
    }

}
