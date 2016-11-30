package main.riot.repositories;

import main.riot.domain.champion.ChampionDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-30.
 */
public interface ChampionDtoRepository extends MongoRepository<ChampionDto, String> {
    ChampionDto findByChampionId(long championId);
}
