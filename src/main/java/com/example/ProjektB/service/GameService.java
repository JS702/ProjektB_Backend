package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.Round;
import com.example.ProjektB.domainobject.RoundWrapper;
import com.example.ProjektB.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameService {

    private final GameRepository gameRepository;

    private final RoundService roundService;

    private final MediaFileService mediaFileService;


    public RoundWrapper createRoundWrapper( int roundCount ) {
        RoundWrapper roundWrapper = new RoundWrapper();
        List<Round> rounds = this.roundService.createRoundDataTest( roundCount );
        roundWrapper.setRounds(rounds);
        roundWrapper.setMediaFiles(getMediaFiles(rounds));
        return roundWrapper;
    }

    public Game save( Game game ) {
        return this.gameRepository.save( game );
    }

    private List<MediaFile> getMediaFiles(List<Round> rounds) {
        List<String> ids = rounds.stream().map( round -> round.getId() ).collect( Collectors.toList() );
        return this.mediaFileService.getMediaFileList(ids);
    }

}