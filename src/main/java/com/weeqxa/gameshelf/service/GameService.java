package com.weeqxa.gameshelf.service;


import com.weeqxa.gameshelf.client.RawgClient;
import com.weeqxa.gameshelf.dto.GameDto;
import com.weeqxa.gameshelf.dto.GamesResponseDto;
import com.weeqxa.gameshelf.dto.rawg.RawgGameDto;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final RawgClient rawgClient;

    public GameService(RawgClient rawgClient) {
        this.rawgClient = rawgClient;
    }


    public GamesResponseDto searchGames(String name) {

        return new GamesResponseDto(rawgClient
                .searchGames(name)
                .getResults()
                .stream()
                .map(this::mapToGameDto)
                .toList());
    }


    private GameDto mapToGameDto(RawgGameDto rawgGameDto) {

        return new GameDto(
                rawgGameDto.getId(),
                rawgGameDto.getName(),
                rawgGameDto.getReleased(),
                rawgGameDto.getBackgroundImage(),
                rawgGameDto.getRating());
    }
}
