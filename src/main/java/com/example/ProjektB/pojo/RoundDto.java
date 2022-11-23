package com.example.ProjektB.pojo;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.domainobject.RoundData;

public class RoundDto {

    private RoundData roundData;

    private MediaFile mediaFile;

    public RoundDto( RoundData roundData, MediaFile mediaFile ) {
        this.roundData = roundData;
        this.mediaFile = mediaFile;
    }

    public RoundData getRoundData() {
        return roundData;
    }

    public MediaFile getMediaFile() {
        return mediaFile;
    }

    public void setRoundData( RoundData roundData ) {
        this.roundData = roundData;
    }

    public void setMediaFile( MediaFile mediaFile ) {
        this.mediaFile = mediaFile;
    }

}
