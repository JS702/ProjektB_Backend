package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.Round;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.GameMode;
import com.example.ProjektB.pojo.GameDto;
import com.example.ProjektB.pojo.LeaderboardEntry;
import com.example.ProjektB.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class GameService {

    private final GameRepository gameRepository;

    private final RoundService roundService;

    private final UserService userService;

    private final MediaFileService mediaFileService;


    public GameDto getGameDto( int roundCount ) {
        GameDto gameDto = new GameDto();
        List<Round> rounds = this.roundService.createRoundDataTest( roundCount );
        gameDto.setRounds( rounds );
        gameDto.setMediaFiles( getMediaFiles( rounds ) );
        return gameDto;
    }

    public List<LeaderboardEntry> getScoreLeaderboard( GameMode gameMode ) {
        List<LeaderboardEntry> leaderboardEntries = new ArrayList<>();
        List<Game> games = this.gameRepository.findAllByGameMode( gameMode ).limit( 10 ).collect( Collectors.toList() );
        games.forEach( game -> createLeaderboardEntry( game, leaderboardEntries ) );
        return leaderboardEntries;
    }

    public Game save( Game game ) {
        return this.gameRepository.save( game );
    }

    private List<MediaFile> getMediaFiles( List<Round> rounds ) {
        List<String> ids = rounds.stream().map( round -> round.getMediaFileId() ).collect( Collectors.toList() );
        return this.mediaFileService.getMediaFileList( ids );
    }

    private void createLeaderboardEntry( Game game, List<LeaderboardEntry> targetList ) {
        LeaderboardEntry leaderboardEntry = new LeaderboardEntry();
        User user = this.userService.getUser( game.getUserId() );
        leaderboardEntry.setUsername( user.getUsername() );
        leaderboardEntry.setScore( game.getScore().getScore() );
        Long gamesPlayed = this.gameRepository.findAllByUserId( user.getId() ).count();
        leaderboardEntry.setGamesPlayed( gamesPlayed );
        targetList.add( leaderboardEntry );
    }

}