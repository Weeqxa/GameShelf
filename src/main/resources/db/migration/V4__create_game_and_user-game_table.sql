CREATE TABLE games
(

    id       BIGSERIAL PRIMARY KEY,

    rawg_id  BIGINT UNIQUE NOT NULL,

    name     VARCHAR(255)  NOT NULL,
    released DATE,
    image    VARCHAR(255),
    rating   NUMERIC
);


CREATE TABLE user_games
(
    id           BIGSERIAL PRIMARY KEY,

    game_id      BIGINT NOT NULL,
    user_id      BIGINT NOT NULL,

    status       VARCHAR(255),
    rating       NUMERIC,
    hours_played INTEGER,
    notes        VARCHAR(255),
    favorite     BOOLEAN NOT NULL DEFAULT FALSE,

    UNIQUE (user_id, game_id),

    CONSTRAINT fk_user_games_game_id
        FOREIGN KEY (game_id) REFERENCES games (id),

    CONSTRAINT fk_user_games_user_id
        FOREIGN KEY (user_id) REFERENCES users (id)
);

