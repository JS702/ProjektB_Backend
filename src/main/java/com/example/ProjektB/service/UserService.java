package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.exception.NotFoundException;
import com.example.ProjektB.pojo.ProfileData;
import com.example.ProjektB.pojo.RegistrationData;
import com.example.ProjektB.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        final User user = this.userRepo.findByUsernameAndDeletedIsFalse( username );
        if ( user == null ) {
            throw new NotFoundException();
        }
        return user;
    }


    public User createUser( final RegistrationData userData, final UserType type ) {

        if ( this.userRepo.findByEmailAndDeletedIsFalse( userData.getEmail() ) != null ) {
            throw new IllegalStateException( "Email is already taken!" );
        }

        if ( this.userRepo.findByUsernameAndDeletedIsFalse( userData.getUsername() ) != null ) {
            throw new IllegalStateException( "Username is already taken!" );
        }
        User user = new User();
        user.setType( type );
        user.setPassword( this.passwordEncoder.encode( userData.getPassword() ) );
        user.setUsername( userData.getUsername() );
        user.setEmail( userData.getEmail() );

        return saveUser( user );
    }

    public User update( final String userId, final ProfileData profileData ) {
        User user = getUser( userId );
        user.setUsername( profileData.getUsername() );
        user.setEmail( profileData.getEmail() );
        user.setDescription( profileData.getDescription() );
        return saveUser( user );
    }

    public void delete( String userId ) {
        User user = getUser( userId );
        user.setUsername( "Deleted User" );
        user.setDeleted( true );
        saveUser( user );
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

}
