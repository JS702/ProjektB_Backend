package com.example.ProjektB.domainobject;

import lombok.Data;

import java.util.List;

@Data
public class GameDto {

    private List<Round> rounds;

    private List<MediaFile> mediaFiles;

}
