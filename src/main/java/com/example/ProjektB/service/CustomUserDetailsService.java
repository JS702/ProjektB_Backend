package com.example.ProjektB.service;

import com.example.ProjektB.config.CustomUserDetails;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.exception.NotFoundException;
import com.example.ProjektB.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsernameAndDeletedIsFalse( username );

        if ( user == null ) {
            throw new NotFoundException( username );
        }
        return new CustomUserDetails( user );
    }

}
