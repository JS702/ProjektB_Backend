package com.example.ProjektB.domainobject;

import com.example.ProjektB.domainvalue.GameMode;
import lombok.Data;

import java.util.List;

@Data
public class RoundWrapper {

    private List<Round> rounds;

    private List<MediaFile> mediaFiles;
}
