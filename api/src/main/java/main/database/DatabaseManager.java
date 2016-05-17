package main.database;

import main.toornament.DisciplineHelper;
import main.toornament.domain.*;
import main.toornament.endpoints.DisciplineService;
import main.toornament.endpoints.MatchesService;
import main.toornament.endpoints.ParticipantsService;
import main.toornament.endpoints.TournamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    private List<String> teams = new ArrayList<>();

    @Scheduled(initialDelay = 1000L, fixedRate = 43000000L)
    public void populateAndUpdateDB() throws Exception {
        System.out.println("Running scheduler");
        for( DisciplineHelper disciplineHelper : DisciplineHelper.values() ) {
            System.out.println(disciplineHelper.getDiscipline());
            Tournament[] tournaments = tournamentsService.getTournaments(disciplineHelper.getDiscipline());
            for (Tournament tournament : tournaments) {
                Tournament tournament1 = tournamentsService.getTournamentInfo(tournament.getTournamentId());
                databaseHandler.addSingleTournamentToDB(tournament1);

                Match[] matchesInTournament = matchesService.getMatchesInTournament(tournament.getTournamentId());
                for (Match match : matchesInTournament) {
                    Match informationOnMatch = matchesService.getInformationOnMatch(tournament.getTournamentId(), match.getId());
                    String matchName = "";
                    for (Opponent opponent : informationOnMatch.getOpponents()) {
                        Participant participant = opponent.getParticipant();
                        if ( participant != null) {

                            if(matchName.isEmpty()) {
                                matchName = participant.getName();
                            }
                            else{
                                matchName+= " vs " + participant.getName();
                            }

                            if(!teams.contains( participant.getId() )) {
                                Participant team = participantsService.getPlayersInTournament( tournament.getTournamentId(), participant.getId());
                                team.setDiscipline( disciplineHelper.getDiscipline() );
                                participant.setPlayers( team.getPlayers());

                                if (team.getPlayers() != null) {
                                    for (Player player : team.getPlayers()) {
                                        player.setTeam( participant );
                                        player.setDiscipline( disciplineHelper.getDiscipline() );
                                    }
                                    databaseHandler.addPlayer(team.getPlayers(), team);
                                }
                                Thread.sleep(1000);
                                databaseHandler.addTeam( team );
                                System.out.println("Adding team : " + participant.getName() + " to list");
                                teams.add( participant.getId() );
                            } else{
                                System.out.println("Not adding team already in list : " + participant.getName());
                            }
                        }
                    }
                    System.out.println("Match name: " + matchName);
                    informationOnMatch.setName( matchName );
                    databaseHandler.addMatch(informationOnMatch);
                    Thread.sleep(1000);
                }
            }
            Discipline discipline = disciplineService.getDiscipline( disciplineHelper.getDiscipline() );
            databaseHandler.addDiscipline(discipline);
            teams.clear();
            Thread.sleep(1000);
        }
    }
}
