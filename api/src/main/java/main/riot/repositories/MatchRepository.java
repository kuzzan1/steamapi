package main.riot.repositories;

import main.riot.domain.match.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-28.
 */
public interface MatchRepository extends MongoRepository<Match, String>{
    Match findByMatchId(Long matchId);
}
