package com.example.ProjektB.pojo;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.Score;
import com.example.ProjektB.domainvalue.RoundType;
import lombok.Data;

import java.util.List;

@Data
public class GameDto {

    private RoundType roundType;

    private List<MediaFile> pictures;

    private Score score;

    private String userId;

}
