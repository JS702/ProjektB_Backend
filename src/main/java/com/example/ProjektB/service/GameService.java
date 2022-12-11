package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.Game;
import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.Round;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.GameMode;
import com.example.ProjektB.pojo.GameDto;
import com.example.ProjektB.pojo.LeaderboardEntry;
import com.example.ProjektB.pojo.ProfileDto;
import com.example.ProjektB.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        //Bisschen hässlich gemacht, aber mir ist auf die schnelle nix eingefallen
        List<LeaderboardEntry> leaderboardEntries = new ArrayList<>();
        List<Game> games = new ArrayList<>();
        List<String> userIds = new ArrayList<>();
        this.gameRepository.findAllByGameMode( gameMode ).limit( 15 ).forEach( game -> {
            if ( !userIds.contains( game.getUserId() ) ) {
                games.add( game );
                userIds.add( game.getUserId() );
            }
        } );
        games.forEach( game -> createLeaderboardEntry( game, leaderboardEntries ) );
        return leaderboardEntries;
    }

    public ProfileDto getProfile( final String userId ) {
        Optional<Game> game1 = this.gameRepository.findAllByUserIdAndGameMode( userId, GameMode.CASUAL ).findFirst();
        Optional<Game> game2 = this.gameRepository.findAllByUserIdAndGameMode( userId, GameMode.ROUNDTIME ).findFirst();
        Optional<Game> game3 = this.gameRepository.findAllByUserIdAndGameMode( userId, GameMode.TOTALTIME ).findFirst();
        Long gamesPlayed1 = this.gameRepository.findAllByUserIdAndGameMode( userId, GameMode.CASUAL ).count();
        Long gamesPlayed2 = this.gameRepository.findAllByUserIdAndGameMode( userId, GameMode.ROUNDTIME ).count();
        Long gamesPlayed3 = this.gameRepository.findAllByUserIdAndGameMode( userId, GameMode.TOTALTIME ).count();
        ProfileDto profileDto =
                new ProfileDto( getScoreFromGame( game1 ), getScoreFromGame( game2 ), getScoreFromGame( game3 ), gamesPlayed1, gamesPlayed2,
                        gamesPlayed3 );
        return profileDto;
    }

    private Integer getScoreFromGame( Optional<Game> game ) {
        if ( !game.isPresent() || game.get().getScore() == null ) {
            return null;
        } else {
            return game.get().getScore().getScore();
        }
    }


    public Game save( Game game ) {
        return this.gameRepository.save( game );
    }


    private List<MediaFile> getMediaFiles( List<Round> rounds ) {
        List<String> ids = rounds.stream().map( round -> round.getMediaFileId() ).collect( Collectors.toList() );
        return this.mediaFileService.getMediaFileList( ids );
    }

    //TODO für gamesPlayed wird keine eigene Suche gestartet
    private void createLeaderboardEntry( Game game, List<LeaderboardEntry> targetList ) {
        LeaderboardEntry leaderboardEntry = new LeaderboardEntry();
        if ( game != null ) {
            User user = this.userService.getUser( game.getUserId() );
            leaderboardEntry.setUsername( user.getUsername() );
            if ( game.getScore() != null ) {
                leaderboardEntry.setScore( game.getScore().getScore() );
            }
            Long gamesPlayed = this.gameRepository.findAllByUserId( user.getId() ).count();
            leaderboardEntry.setGamesPlayed( gamesPlayed );
            targetList.add( leaderboardEntry );
        }

    }

}