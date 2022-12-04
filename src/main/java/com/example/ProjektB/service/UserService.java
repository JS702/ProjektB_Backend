package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.RegistrationData;
import com.example.ProjektB.domainobject.Score;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.exception.NotFoundException;
import com.example.ProjektB.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class UserService {

    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    public User getUser( final String userId ) {
        log.info( "Looking for user: {}", userId );
        final User user = this.userRepo.findById( userId ).orElseThrow( NotFoundException::new );
        return user;
    }

    public User getUserByUsername( final String username ) {
        log.info( "Looking for user: {}", username );
        final User user = this.userRepo.findByUsername( username );
        if ( user == null ) {
            throw new NotFoundException();
        }
        return user;
    }

    public User createUser( final RegistrationData userData, final UserType type ) {

        if ( this.userRepo.findByEmail( userData.getEmail() ) != null ) {
            throw new IllegalStateException( "Email is already taken!" );
        }

        if ( this.userRepo.findByUsername( userData.getUsername() ) != null ) {
            throw new IllegalStateException( "Username is already taken!" );
        }
        User user = new User();
        user.setType( type );
        user.setPassword( this.passwordEncoder.encode( userData.getPassword() ) );
        user.setScores( new ArrayList<>() );

        return saveUser( user );
    }

    public User updateProfilePicture( String userId, String profilePictureId ) {
        User user = getUser( userId );
        user.setProfilePictureId( profilePictureId );
        return saveUser( user );
    }

    private User saveUser( final User user ) {
        log.info( "Saving user..." );
        return this.userRepo.save( user );
    }


    public User setScore( final String userId, final Score newScore ) {
        User user = getUser( userId );
        Optional<Score> score = user.getScoreByGameMode( newScore.getGameMode() );
        if ( !score.isPresent() ) {
            user.getScores().add( newScore );
            this.saveUser( user );
        } else if ( score.get().getScore() < newScore.getScore() ) {
            user.getScores().remove( score.get() );
            user.getScores().add( newScore );
            this.saveUser( user );
        }
        return user;
    }

}
