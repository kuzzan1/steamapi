package main.toornament;

/**
 * Created by jonas on 2016-02-12.
 */
public enum DisciplineHelper {
    SMITE( "smite" ),
    HEARTHSTONE( "hearthstone" ),
    HEAROESOFTHESTORM( "heroesofthestorm" ),
    CS_GO( "counterstrike_go" ),
    DOTA2( "dota2" ),
    LOL( "leagueoflegends" ),
    FIFA16("fifa16");

    private final String discipline;

    DisciplineHelper( String discipline ) {
        this.discipline = discipline;
    }

    public static boolean contains( String discipline ) {
        DisciplineHelper[] values = DisciplineHelper.values();
        for( DisciplineHelper value : values ) {
            if( value.getDiscipline().equalsIgnoreCase( discipline ) ) {
                return true;
            }
        }
        return false;
    }

    public String getDiscipline() {
        return discipline;
    }
}
