package com.example.fakedata.mapper;

import com.example.fakedata.domain.User;
import com.example.fakedata.dto.UserDto;

public class UserMapper
{
   public static UserDto toDto(User u)
   {
      return new UserDto(u.getId(), u.getFullName(), u.getEmail(), u.getPhone(), u.getAddress());
   }
}
