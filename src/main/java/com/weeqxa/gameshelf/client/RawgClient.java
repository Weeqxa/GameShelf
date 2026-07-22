package com.weeqxa.gameshelf.client;


import com.weeqxa.gameshelf.config.RawgProperties;
import com.weeqxa.gameshelf.dto.rawg.RawgGamesResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class RawgClient {

    private final RawgProperties rawgProperties;

    private final RestClient restClient;

    public RawgClient(RawgProperties rawgProperties, RestClient restClient) {
        this.rawgProperties = rawgProperties;
        this.restClient = restClient;
    }

    public RawgGamesResponseDto searchGames(String game) {

        return restClient.get().uri(uriBuilder -> uriBuilder
                        .path("/games")
                        .queryParam("search", game)
                        .queryParam("key", rawgProperties.getApiKey())
                        .build()
                )
                .retrieve()
                .body(RawgGamesResponseDto.class);
    }
}
