package com.weeqxa.gameshelf.service;


import com.weeqxa.gameshelf.dto.library.LibraryGameInfoDto;
import com.weeqxa.gameshelf.dto.library.LibraryGameResponseDto;
import com.weeqxa.gameshelf.entity.UserGame;
import com.weeqxa.gameshelf.repository.UserGameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LibraryGameService {

    private final UserGameRepository userGameRepository;

    public LibraryGameService(UserGameRepository userGameRepository) {
        this.userGameRepository = userGameRepository;
    }


    @Transactional(readOnly = true)
    public List<LibraryGameResponseDto> getMyLibrary(Long userId) {

        List<UserGame> userGames = userGameRepository.findAllByUser_Id(userId);

        return toLibraryGameResponseDtos(userGames);
    }

    private List<LibraryGameResponseDto> toLibraryGameResponseDtos(List<UserGame> userGames) {

        return userGames.stream().map(userGame -> new LibraryGameResponseDto(
                new LibraryGameInfoDto(
                        userGame.getGame().getName(),
                        userGame.getGame().getReleased(),
                        userGame.getGame().getImage(),
                        userGame.getGame().getRating()
                ),
                userGame.getStatus(),
                userGame.getRating(),
                userGame.getHoursPlayed(),
                userGame.getNotes(),
                userGame.isFavorite()
        )).toList();
    }

}
