package com.example.ProjektB.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.domainvalue.RoundType;
import com.example.ProjektB.repositories.RoundRepository;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoundDataService {

    private final RoundRepository roundRepository;

    public List<RoundData> createRoundDataTest(int rounds) {

        List<RoundData> roundDataList = roundRepository.findByType(RoundType.PUBG);// TODO aus frontend übergeben
        log.info("Size: {}", roundDataList.size());

        while (roundDataList.size() > 5) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, roundDataList.size());

            roundDataList.remove(randomInt);
        }
        return roundDataList;
    }

    public RoundData save(RoundData roundData) {
        return this.roundRepository.save(roundData);
    }
}