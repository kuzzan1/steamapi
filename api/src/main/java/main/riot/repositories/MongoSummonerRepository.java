package main.riot.repositories;

import main.riot.domain.summoner.SummonerDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-28.
 */
public interface MongoSummonerRepository extends MongoRepository<SummonerDto, String> {
    SummonerDto findByNameAndLocale(String name, String locale);
    SummonerDto findByIdAndLocale(int id, String locale);
    SummonerDto findByLowerCaseNameAndLocale(String lowerCaseName, String locale);
}
