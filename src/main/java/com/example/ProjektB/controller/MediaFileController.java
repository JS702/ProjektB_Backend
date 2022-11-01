package com.example.ProjektB.controller;

import com.example.ProjektB.service.MediaFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping( value = "/mediafile" )
@RequiredArgsConstructor( onConstructor = @__( @Autowired ) )
public class MediaFileController {

    private final MediaFileService mediaFileService;

    @PostMapping("/profilepicture/{userId}")
    public ResponseEntity<Void> updateProfilePicture(@PathVariable String userId, @RequestParam final MultipartFile file) throws IOException {
        this.mediaFileService.updateProfilePicture( userId, file );
        return ResponseEntity.ok().build();
    }

}