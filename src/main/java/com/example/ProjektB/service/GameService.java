package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainobject.GameDto;
import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.Round;
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


    public GameDto getGameDto( int roundCount ) {
        GameDto gameDto = new GameDto();
        List<Round> rounds = this.roundService.createRoundDataTest( roundCount );
        gameDto.setRounds( rounds );
        gameDto.setMediaFiles( getMediaFiles( rounds ) );
        return gameDto;
    }

    public Game save( Game game ) {
        return this.gameRepository.save( game );
    }

    private List<MediaFile> getMediaFiles( List<Round> rounds ) {
        List<String> ids = rounds.stream().map( round -> round.getMediaFileId() ).collect( Collectors.toList() );
        return this.mediaFileService.getMediaFileList( ids );
    }

}