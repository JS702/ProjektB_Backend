package com.example.ProjektB.mapper;

import com.example.ProjektB.domainobject.MediaFile;
import com.example.ProjektB.pojo.MediaFileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Value;

@Mapper(componentModel = "spring")
public interface MediaFileMapper {

    public abstract MediaFile mapDto( MediaFileDto mediaFileDto);

    public abstract MediaFileDto mapToDto( MediaFile mediaFile);

}