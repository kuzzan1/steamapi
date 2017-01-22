package main.riot.repositories;

import main.riot.domain.champion.ChampionListDto;

import org.springframework.data.mongodb.repository.MongoRepository;

interface MongoChampionListDtoRepository extends MongoRepository<ChampionListDto, String > {

    ChampionListDto findByUrl( String url );
}	