package main.riot.repositories;

import main.riot.domain.summoner.SummonerDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-28.
 */
public interface SummonerRepository extends MongoRepository<SummonerDto, String> {
    SummonerDto findByName(String name, String locale);
    SummonerDto findById(int id, String locale);
    SummonerDto findByLowerCaseName(String lowerCaseName, String locale);
}
