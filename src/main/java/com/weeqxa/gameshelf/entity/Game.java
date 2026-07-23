package com.weeqxa.gameshelf.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rawg_id", nullable = false, unique = true)
    private Long rawgId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "released")
    private LocalDate released;

    @Column(name = "image")
    private String image;

    @Column(name = "rating")
    private BigDecimal rating;



}
