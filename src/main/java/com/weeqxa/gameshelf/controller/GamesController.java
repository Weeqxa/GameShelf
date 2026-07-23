package com.weeqxa.gameshelf.controller;


import com.weeqxa.gameshelf.dto.games.GamesResponseDto;
import com.weeqxa.gameshelf.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @Operation(
            summary = "Search games by name",
            description = "Searches for games by the provided name using the RAWG API. " +
                    "Returns a list of games that match the search query. " +
                    "If no games are found, an empty list is returned."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Games successfully retrieved"
            ),
            @ApiResponse(
                    responseCode = "502",
                    description = "RAWG API is unavailable or returned an error"
            )
    })
    @GetMapping("/search")
    public GamesResponseDto getGames(
            @Parameter(
                    description = "Game name to search for",
                    example = "The Witcher 3"
            )
            @RequestParam String gameName
    ) {
        return gameService.searchGames(gameName);
    }













}
