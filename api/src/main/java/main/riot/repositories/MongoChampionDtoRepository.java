package main.riot.repositories;

import main.riot.domain.champion.ChampionDto;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoChampionDtoRepository extends MongoRepository<ChampionDto, String>{
	public ChampionDto findByChampionId(long championId);
}
