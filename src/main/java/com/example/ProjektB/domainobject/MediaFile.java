package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.MediaFileType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document( collection = "mediaFile" )
@JsonInclude( JsonInclude.Include.NON_NULL )
public class MediaFile {

    @Id
    private String id;

    private String path;

    private MediaFileType type;

    private String fileExtension;

}
