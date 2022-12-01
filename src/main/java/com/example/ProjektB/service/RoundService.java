package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.Round;
import com.example.ProjektB.domainvalue.RoundType;
import com.example.ProjektB.repositories.RoundRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class RoundService {

    private final RoundRepository roundRepository;

    public List<Round> createRoundDataTest( int roundCount ) {

        List<Round> allRoundData = this.roundRepository.findByType( RoundType.PUBG );// TODO aus frontend übergeben
        List<Round> rounds = new ArrayList<>();

        for ( int i = 0; i < roundCount; i++ ) {
            int randomInt = ThreadLocalRandom.current().nextInt( 0, allRoundData.size() );

            rounds.add( allRoundData.remove( randomInt ) );
        }

        return rounds;
    }

    public List<String> getRoundIds( int roundCount ) {
        List<Round> allRoundData = createRoundDataTest( roundCount );
        return allRoundData.stream().map( round -> round.getId() ).collect( Collectors.toList() );
    }

    public Round save( Round round ) {
        return this.roundRepository.save( round );
    }

}