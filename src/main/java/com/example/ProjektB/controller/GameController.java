package com.example.ProjektB.controller;

import com.example.ProjektB.pojo.RoundDto;
import com.example.ProjektB.service.RoundDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( value = "/game" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameController {

    private final RoundDataService roundDataService;

    @GetMapping
    public List<RoundDto> getGameDto( @RequestParam int rounds ) {
        return this.roundDataService.createRoundDataTest( rounds );
    }

}