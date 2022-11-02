package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.repositories.MediaFileRepository;
import com.example.ProjektB.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MediaFileService {

    private final DefaultUserService userService;

    private final MediaFileRepository repository;

    @Value("${app.files.path}")
    private String destinationPath;

    public void updateProfilePicture(String userId, MultipartFile multipartFile) throws IOException {
        File file = FileUtils.convertMultipartToFile(destinationPath + "/profilepictures", multipartFile);
        log.info("File {}", file.getPath());
        // file.createNewFile();
    }

    private MediaFile save(final MediaFile file){
        return this.repository.save(file);
    }

}