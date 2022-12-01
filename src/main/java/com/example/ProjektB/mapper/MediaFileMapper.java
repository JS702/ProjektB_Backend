package com.example.ProjektB.mapper;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.pojo.MediaFileDto;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface MediaFileMapper {

    MediaFile mapDto( MediaFileDto mediaFileDto );

    MediaFileDto mapToDto( MediaFile mediaFile );

}