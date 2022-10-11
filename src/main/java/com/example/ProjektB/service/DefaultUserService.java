package com.example.ProjektB.service;


import com.example.ProjektB.PasswordProperties;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.exception.NotFoundException;
import com.example.ProjektB.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class DefaultUserService {

    private final UserRepository userRepo;

    public User getUser( final String userId ) {
        final User user = this.userRepo.findById( userId ).orElseThrow( NotFoundException::new );
        if ( user == null ) {
            throw new NotFoundException();
        }

        return user;
    }

    private void saveUser( final User user ) {
        this.userRepo.save( user );
    }
}
