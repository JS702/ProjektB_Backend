package com.example.ProjektB.mapper;

import com.example.ProjektB.domainobject.User;
import com.example.ProjektB.pojo.UserDto;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring" )
public interface UserMapper {

    User mapDto( UserDto userDto );

    UserDto mapToDto( User user );

}
