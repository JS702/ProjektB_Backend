package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.RoundData;
import com.example.ProjektB.mapper.MediaFileMapper;
import com.example.ProjektB.pojo.MediaFileDto;
import com.example.ProjektB.service.MediaFileService;
import com.example.ProjektB.service.RoundDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping( value = "/admin" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class AdminController {

    private final RoundDataService roundDataService;

    private final MediaFileService mediaFileService;

    private final MediaFileMapper mediaFileMapper;

    @PutMapping( "/round_data" )
    public RoundData createRoundData( @RequestBody RoundData roundData ) {
        return this.roundDataService.save( roundData );
    }

    @PutMapping( "/round_file" )
    public MediaFileDto createRoundData( @RequestBody MultipartFile file ) throws IOException {
        return mediaFileMapper.mapToDto( this.mediaFileService.createRoundFile( file ) );
    }

}
