package main.riot.helper;

import main.riot.domain.match.Match;
import main.riot.domain.match.Participant;
import main.riot.domain.match.ParticipantIdentity;
import main.riot.domain.match.Team;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonas on 2016-11-24.
 */
@Component
public class PlayerWinHelper {

    public Boolean[] getPlayerLastMatches(List<Match> matches, long summonerId) {
        List<Boolean> storage = new ArrayList<>();
        int participantId = -1;
        for (Match match : matches) {
            for (ParticipantIdentity participantIdentity : match.getParticipantIdentities()) {
                if(participantIdentity.getPlayer().getSummonerId() == summonerId) {
                    participantId = participantIdentity.getParticipantId();
                    break;
                }
            }
            for (Participant participant : match.getParticipants()) {
                if(participant.getParticipantId() == participantId) {
                    for (Team team : match.getTeams()) {
                        if(team.getTeamId() == participant.getTeamId()) {
                            storage.add(team.isWinner());
                        }
                    }
                }
            }

        }
        return storage.toArray(new Boolean[storage.size()]);
    }
}
