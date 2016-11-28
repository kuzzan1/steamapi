package main.riot.endpoints;

import main.URLBuilder;
import main.helper.ApiKey;
import main.riot.domain.champion.ChampionListDto;
import main.riot.domain.item.ItemListDto;
import main.riot.domain.map.MapDataDto;
import main.riot.domain.mastery.MasteryListDto;
import main.riot.domain.rune.RuneListDto;
import main.riot.domain.spell.SummonerSpellListDto;
import main.riot.domain.test.Customer;
import main.riot.domain.test.CustomerRepository;
import main.riot.repositories.ChampionListDtoRepository;
import main.steam.bean.RestTemplateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jonas on 2016-11-17.
 */
@RestController
@RequestMapping( "/app/lol/static/" )
public class StaticDataController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ChampionListDtoRepository championListDtoRepository;

    @Autowired
    private RestTemplateBean restTemplateBean;

    @Autowired
    private HttpServletRequest request;


    @RequestMapping( "items" )
    public ItemListDto getItemsData() {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/item" ).Param( "itemListData", "all" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange( url, ItemListDto.class );
    }

    @RequestMapping( "maps" )
    public MapDataDto getMapData() {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/map" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange( url, MapDataDto.class );
    }

    @RequestMapping( "masteries" )
    public MasteryListDto getMasteryData() {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/mastery" ).Param( "masteryListData", "all" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange( url, MasteryListDto.class );
    }

    @RequestMapping( "spells" )
    public SummonerSpellListDto getSpellListData() {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/summoner-spell" ).Param( "spellData", "all" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange( url, SummonerSpellListDto.class );
    }

    @RequestMapping( "runes" )
    public RuneListDto getRunesData() {
        String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/rune" ).Param( "runeListData", "all" ).Param( "api_key", ApiKey.getRiotKey() ).Build();
        return restTemplateBean.exchange( url, RuneListDto.class );
    }

    @RequestMapping( "champions" )
    public ChampionListDto getChampionsStatic() {
        ChampionListDto championListDto = championListDtoRepository.findByUrl( request.getRequestURI() );
        if( championListDto == null) {
            String url = new URLBuilder().baseUrl( "https://global.api.pvp.net/api/lol/static-data/eune/v1.2/champion" ).Param( "champDat", "all" ).buildRiot();
            championListDto = restTemplateBean.exchange( url, ChampionListDto.class );
            championListDto.setUrl( request.getRequestURI() );
            championListDtoRepository.save( championListDto );
        }
        return championListDto;
    }

    @RequestMapping( "test" )
    public void trest() {
        Customer customer = new Customer( "jonas", "lund");
        customerRepository.save( customer );
        System.out.println(customerRepository.findByFirstName( "jonas" ));
        System.out.println(customerRepository.findByLastName( "lund" ));
    }
}
