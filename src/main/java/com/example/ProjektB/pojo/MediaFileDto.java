package com.example.ProjektB.pojo;

import com.example.ProjektB.domainvalue.MediaFileType;
import lombok.Data;

@Data
public class MediaFileDto {

    private String id;

    private String path;

    private MediaFileType type;

    private String fileExtension;

}
