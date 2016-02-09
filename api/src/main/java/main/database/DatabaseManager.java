package main.database;

import main.toornament.domain.*;
import main.toornament.endpoints.DisciplineService;
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

    @Autowired
    private DisciplineService disciplineService;

    @Scheduled(initialDelay = 1000L, fixedRate = 43000000L)
    public void getTournaments() throws Exception {
        System.out.println("Running scheduler");
        Discipline[] disciplines = disciplineService.getDisciplines();
        for (Discipline discipline : disciplines) {

            // Tournament[] tournaments = tournamentsService.getCSGO();
            Tournament[] tournaments = tournamentsService.getTournaments(discipline.getId());
            for (Tournament tournament : tournaments) {
                Tournament tournament1 = tournamentsService.getTournamentInfo(tournament.getTournamentId());
                databaseHandler.addSingleTournamentToDB(tournament1);

                Match[] matchesInTournament = matchesService.getMatchesInTournament(tournament.getTournamentId());
                for (Match match : matchesInTournament) {
                    Match informationOnMatch = matchesService.getInformationOnMatch(tournament.getTournamentId(), match.getId());
                    for (Opponent opponent : informationOnMatch.getOpponents()) {
                        if (opponent.getParticipant() != null) {
                            Participant team = participantsService.getPlayersInTournament(tournament.getTournamentId(), opponent.getParticipant().getId());
                            opponent.getParticipant().setPlayers(team.getPlayers());
                            if (team.getPlayers() != null) {
                                for (Player player : team.getPlayers()) {
                                    player.setTeam(opponent.getParticipant());
                                }
                                databaseHandler.addPlayer(team.getPlayers(), team);
                            }
                            Thread.sleep(1000);
                        }
                    }
                    databaseHandler.addMatch(informationOnMatch);
                    Thread.sleep(1000);
                }
            }
            databaseHandler.addSport(discipline);
            Thread.sleep(1000);
        }
    }

/*    @Scheduled(initialDelay = 1000L, fixedRate = 43000000L )
    public void test() throws Exception {
        Match informationOnMatch = matchesService.getInformationOnMatch( "5624fc83150ba0c6088b4569", "563a12cb140ba0af188b460d" );
        for (Opponent opponent : informationOnMatch.getOpponents()) {
            Participant players = participantsService.getPlayersInTournament( "5624fc83150ba0c6088b4569",  opponent.getParticipant().getId());
            opponent.getParticipant().setPlayers(players.getPlayers());
            for (Player player : players.getPlayers()) {
                player.setTeam(opponent.getParticipant());
            }
        }

        databaseHandler.addMatch( informationOnMatch );

        //Participant[] teams = participantsService.getPlayersInTournament( "569f91be150ba0434e8b4573" );
        // Participant players = participantsService.getPlayersInTournament( "569f91be150ba0434e8b4573", "569f921c140ba0b6398b4710" );
    }*/
}
