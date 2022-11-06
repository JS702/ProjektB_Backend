package com.example.ProjektB.mapper;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.pojo.MediaFileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Value;

@Mapper(componentModel = "spring")
public abstract class MediaFileMapper {

    @Value("${app.files.path}")
    String path;


    public abstract MediaFile mapDto( MediaFileDto mediaFileDto);

    @Mapping(target = "path", expression = "java(getPath() + mediaFile.getPath())")
    public abstract MediaFileDto mapToDto( MediaFile mediaFile);


    protected String getPath(){
        return path;
    }
}