package main.database;

import main.toornament.domain.Match;
import main.toornament.domain.Participant;
import main.toornament.domain.Tournament;
import main.toornament.endpoints.MatchesService;
import main.toornament.endpoints.ParticipantsService;
import main.toornament.endpoints.TournamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by jonas on 2016-02-02.
 */
@Component
public class DatabaseManager {

    @Autowired
    private TournamentsService tournamentsService;

    @Autowired
    private ParticipantsService participantsService;

    @Autowired
    private MatchesService matchesService;

    @Autowired
    private DatabaseHandler databaseHandler;

    @Scheduled(initialDelay = 1000L, fixedRate = 43000000L )
    public void getTournaments() throws Exception{
        System.out.println("Running scheduler");
        Tournament[] tournaments = tournamentsService.getTournaments();
        for( Tournament tournament : tournaments ) {
            Tournament tournament1 = tournamentsService.getTournaments( tournament.getTournamentId() );
            databaseHandler.addSingleTournamentToDB( tournament1 );

            Match[] matchesInTournament = matchesService.getMatchesInTournament( tournament.getTournamentId() );
            for( Match match : matchesInTournament ) {
                Match informationOnMatch = matchesService.getInformationOnMatch( tournament.getTournamentId(), match.getId() );
                databaseHandler.addMatch( informationOnMatch );
                Thread.sleep( 1000 );
            }
            Participant[] teams = participantsService.getPlayersInTournament( tournament.getTournamentId() );
            for( Participant team : teams ) {
                databaseHandler.addTeam( team );

                Participant players = participantsService.getPlayersInTournament( tournament.getTournamentId(), team.getId() );
                if(players.getPlayers() != null) {
                    databaseHandler.addPlayer( players.getPlayers(), team );
                }

                Thread.sleep( 1000 );
            }
            Thread.sleep( 1000 );
        }


    }
   /* @Scheduled(initialDelay = 1000L, fixedRate = 43000000L )
    public void test() throws Exception {
        //Match informationOnMatch = matchesService.getInformationOnMatch( "5624fc83150ba0c6088b4569", "563a12cb140ba0af188b460d" );
        //Participant[] teams = participantsService.getPlayersInTournament( "569f91be150ba0434e8b4573" );
        // Participant players = participantsService.getPlayersInTournament( "569f91be150ba0434e8b4573", "569f921c140ba0b6398b4710" );
    }*/
}
