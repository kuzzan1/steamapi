package main.riot.domain.match;

import java.util.List;

public interface IMatchInfo {
	long getId();
	List<? extends IParticipant> getMatchParticipants();
}
