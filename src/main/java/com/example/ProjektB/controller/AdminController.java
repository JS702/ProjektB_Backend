package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AdminController {

    private final GameService gameService;

    @PutMapping("/round_data")
    public RoundData login(@RequestBody RoundData roundData) {
        return this.gameService.save(roundData);
    }
}
