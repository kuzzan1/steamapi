package main.riot.repositories;

import main.riot.domain.game.RecentGamesDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-30.
 */
public interface RecentGamesDtoRepository extends MongoRepository<RecentGamesDto, String> {
    RecentGamesDto findBySummonerId(long summonerId, String locale);
}
