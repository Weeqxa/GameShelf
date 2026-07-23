package com.weeqxa.gameshelf.repository;

import com.weeqxa.gameshelf.entity.UserGame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserGameRepository extends JpaRepository<UserGame, Long> {

    List<UserGame> findAllByUser_Id(Long userId);

}
