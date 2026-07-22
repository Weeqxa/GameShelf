package com.weeqxa.gameshelf.dto.rawg;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RawgGamesResponseDto {

    private int count;

    private List<RawgGameDto> results;

}
