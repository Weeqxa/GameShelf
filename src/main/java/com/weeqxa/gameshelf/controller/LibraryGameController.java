package com.weeqxa.gameshelf.controller;


import com.weeqxa.gameshelf.dto.library.LibraryGameResponseDto;
import com.weeqxa.gameshelf.security.CustomUserDetails;
import com.weeqxa.gameshelf.service.LibraryGameService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/library")
public class LibraryGameController {

    private final LibraryGameService libraryGameService;

    public LibraryGameController(LibraryGameService libraryGameService) {
        this.libraryGameService = libraryGameService;
    }


    @GetMapping
    public List<LibraryGameResponseDto> getMyLibrary(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return libraryGameService.getMyLibrary(userDetails.getUserId());
    }


}


