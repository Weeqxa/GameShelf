package com.weeqxa.gameshelf.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "user_games")
public class UserGame {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "hours_played")
    private Integer hoursPlayed;

    @Column(name = "notes")
    private String notes;

    @Column(name = "favorite", nullable = false)
    private boolean favorite = false;

}
