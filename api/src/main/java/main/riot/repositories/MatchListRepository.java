package main.riot.repositories;

import main.riot.domain.match.MatchList;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-28.
 */

public interface MatchListRepository extends MongoRepository<MatchList, String>{
    MatchList findBySummonerIdAndLocale(Long summonerId, String locale);
}
