package com.weeqxa.gameshelf.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GamesResponseDto {

    private List<GameDto> games;
}
