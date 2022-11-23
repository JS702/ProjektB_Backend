package com.example.ProjektB.mapper;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.pojo.MediaFileDto;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface MediaFileMapper {

    public MediaFile mapDto( MediaFileDto mediaFileDto );

    public MediaFileDto mapToDto( MediaFile mediaFile );

}