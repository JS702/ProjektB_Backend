package com.example.ProjektB.service;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainvalue.MediaFileType;
import com.example.ProjektB.repositories.MediaFileRepository;
import com.example.ProjektB.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
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

    public MediaFile updateProfilePicture(String userId, MultipartFile multipartFile) throws IOException {
        File file = FileUtils.convertMultipartToFile(destinationPath + "profilepictures", multipartFile);
        return this.save(create(file, MediaFileType.PROFILEPICTURE));
    }

    public MediaFile createRoundFile(MultipartFile multipartFile) throws IOException {
        File file = FileUtils.convertMultipartToFile(destinationPath + "rounds", multipartFile);
        return this.save(create(file, MediaFileType.ROUND));
    }

    private MediaFile create(File file, MediaFileType type) {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setFileExtension(FilenameUtils.getExtension(file.getName()));
        mediaFile.setType(type);
        mediaFile.setName(file.getName());
        return mediaFile;
    }

    private MediaFile save(final MediaFile file) {
        return this.repository.save(file);
    }

}