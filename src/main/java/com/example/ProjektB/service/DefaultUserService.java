package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.domainvalue.UserType;
import com.example.ProjektB.exception.NotFoundException;
import com.example.ProjektB.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultUserService {

    private final UserRepository userRepo;

    public User getUser(final String userId) {
        System.out.println("Looking for user: " + userId);
        final User user = this.userRepo.findById(userId).orElseThrow(NotFoundException::new);
        if (user == null) {
            throw new NotFoundException();
        }
        return user;
    }

    public User createUser(final User user, final UserType type) {
        // TODO hash Password
        user.setType(type);
        return saveUser(user);
    }

    public User saveUser(final User user) {
        log.info("Saving user...");
        return this.userRepo.save(user);
    }
}
