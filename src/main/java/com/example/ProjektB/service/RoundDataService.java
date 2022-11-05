package com.example.ProjektB.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.domainvalue.RoundType;
import com.example.ProjektB.pojo.RoundDto;
import com.example.ProjektB.repositories.RoundRepository;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoundDataService {

    private final RoundRepository roundRepository;
    private final MediaFileService mediaFileService;

    public List<RoundDto> createRoundDataTest(int rounds) {

        List<RoundData> allRoundData = roundRepository.findByType(RoundType.PUBG);// TODO aus frontend übergeben
        List<RoundDto> roundDtos = new ArrayList<RoundDto>();
        
        for (int i = 0; i <= rounds; i++) {
            int randomInt = ThreadLocalRandom.current().nextInt(0, allRoundData.size());
            
            RoundData randomRound = allRoundData.remove(randomInt);
            MediaFile randomPicture = mediaFileService.getMediaFile(randomRound.getMediaFileId());

            roundDtos.add(new RoundDto(randomRound, randomPicture));
        }

        return roundDtos;
    }

    public RoundData save(RoundData roundData) {
        return this.roundRepository.save(roundData);
    }
}