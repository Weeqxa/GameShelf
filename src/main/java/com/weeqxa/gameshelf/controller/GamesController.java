package com.weeqxa.gameshelf.controller;


import com.weeqxa.gameshelf.dto.GamesResponseDto;
import com.weeqxa.gameshelf.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GamesController {

    private final GameService gameService;


    public GamesController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/search")
    public GamesResponseDto getGames(@RequestParam String gameName) {
        return gameService.searchGames(gameName);
    }
}
