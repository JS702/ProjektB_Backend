package com.example.ProjektB.controller;

import com.example.ProjektB.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "/game" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameController {

    private final GameService gameService;
}