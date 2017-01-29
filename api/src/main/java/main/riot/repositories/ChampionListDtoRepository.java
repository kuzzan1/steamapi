package main.riot.repositories;

import main.URLBuilder;
import main.riot.domain.champion.ChampionListDto;
import main.steam.bean.RestTemplateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by jonas on 2016-11-28.
 */

@Repository
public class ChampionListDtoRepository
{
	 @Autowired
	 private RestTemplateBean restTemplateBean;
	 
	 @Autowired
	 private MongoChampionListDtoRepository mongochampionListDtoRepository;
	 
	 public ChampionListDto findByUrl( String url ){
	  ChampionListDto championListDto = mongochampionListDtoRepository.findByUrl( url );
      if( championListDto == null) {
          String newUrl = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/champion" ).Param( "champDat", "all" ).buildRiot();
          championListDto = restTemplateBean.exchange( newUrl, ChampionListDto.class );
          championListDto.setUrl( newUrl );
          if(championListDto.getChampions().size() > 0) //Only save valid responses.
          {
        	  mongochampionListDtoRepository.save( championListDto );
          }
      }
      return championListDto;
	 }
}

