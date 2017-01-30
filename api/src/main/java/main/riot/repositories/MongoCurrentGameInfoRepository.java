package main.riot.repositories;

import main.riot.domain.currentgame.CurrentGameInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-29.
 */
interface MongoCurrentGameInfoRepository extends MongoRepository<CurrentGameInfo, String> {
    CurrentGameInfo findBySummonerIdAndLocale(long summonerId, String locale);
}
