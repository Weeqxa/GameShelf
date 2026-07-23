package com.weeqxa.gameshelf.dto.library;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class LibraryGameInfoDto {

    private String name;

    private LocalDate released;

    private String image;

    private BigDecimal rating;


}
