package main.riot.repositories;

import main.riot.domain.champion.ChampionListDto;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jonas on 2016-11-28.
 */
public interface ChampionListDtoRepository extends MongoRepository<ChampionListDto, String > {

    ChampionListDto findByUrl( String url );
}
