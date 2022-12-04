package com.example.ProjektB.pojo;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.Round;
import lombok.Data;

import java.util.List;

@Data
public class GameDto {

    private List<Round> rounds;

    private List<MediaFile> mediaFiles;

}
