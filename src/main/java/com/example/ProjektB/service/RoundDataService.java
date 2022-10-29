package com.example.ProjektB.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
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

        List<RoundData> allRoundData = roundRepository.findByType(RoundType.PUBG);// TODO aus frontend übergeben
        //log.info("Size: {}", allRoundData.size());
        List<RoundData> randomRoundData = new ArrayList<RoundData>();

        for (int i = 0; i <= rounds; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, allRoundData.size());

            randomRoundData.add(allRoundData.remove(randomInt));
        }

        return randomRoundData;
    }

    public RoundData save(RoundData roundData) {
        return this.roundRepository.save(roundData);
    }
}