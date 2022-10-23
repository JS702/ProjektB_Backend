package com.example.ProjektB.mapper;

import org.mapstruct.Mapper;

import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.pojo.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User mapDto(UserDto userDto);

    UserDto mapToDto(User user);

}
