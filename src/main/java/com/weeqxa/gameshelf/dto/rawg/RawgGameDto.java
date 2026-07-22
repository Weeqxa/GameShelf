package com.weeqxa.gameshelf.dto.rawg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class RawgGameDto {

    private Long id;

    private String name;

    private LocalDate released;

    @JsonProperty("background_image")
    private String backgroundImage;

    private BigDecimal rating;

}
