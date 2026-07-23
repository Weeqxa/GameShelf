package com.weeqxa.gameshelf.dto.library;


import com.weeqxa.gameshelf.entity.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LibraryGameResponseDto {

    private LibraryGameInfoDto game;

    private GameStatus status;

    private BigDecimal myRating;

    private Integer hoursPlayed;

    private String notes;

    private Boolean favorite;

}
