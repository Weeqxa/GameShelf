package com.weeqxa.gameshelf.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class GameDto {

    private Long id;

    private String name;

    private LocalDate released;

    private String image;

    private BigDecimal rating;
}
