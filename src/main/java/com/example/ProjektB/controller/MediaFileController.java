package com.example.ProjektB.controller;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.service.DefaultUserService;
import com.example.ProjektB.service.MediaFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping( value = "/mediafile" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class MediaFileController {

    private final MediaFileService mediaFileService;

    private final DefaultUserService userService;

    @GetMapping( "/{id}" )
    public MediaFile get( @PathVariable String id ) {
        return this.mediaFileService.getMediaFile( id );
    }

    @PostMapping( "/list" )
    public List<MediaFile> getList( @RequestBody List<String> ids ) {
        return this.mediaFileService.getMediaFileList( ids );
    }

    @PostMapping( "/profilepicture/{userId}" )
    public User updateProfilePicture( @PathVariable String userId, @RequestParam final MultipartFile file ) throws IOException {
        MediaFile mediaFile = this.mediaFileService.updateProfilePicture( userId, file );
        return this.userService.updateProfilePicture( userId, mediaFile.getId() );
    }

}