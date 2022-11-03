package com.example.ProjektB.utils;

import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class FileUtils {

    public static File convertMultipartToFile(final String destinationPath, final MultipartFile multipart)
            throws IllegalStateException, IOException {
        String filename = multipart.getOriginalFilename();
        String filepath = Paths.get(destinationPath, filename).toString();
        final File destinationFile = new File(filepath);
        multipart.transferTo(destinationFile);
        return destinationFile;
    }

}
