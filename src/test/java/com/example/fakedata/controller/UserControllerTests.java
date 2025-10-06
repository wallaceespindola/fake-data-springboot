package com.example.fakedata.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fakedata.api.ApiResponse;
import com.example.fakedata.dto.UserDto;

@SpringBootTest
class UserControllerTests
{
   @Autowired
   private UserController controller;

   @Test
   void contextLoads()
   {
      assertNotNull(controller);
   }

   @Test
   void generateUsersWithEasyRandomReturnsTimestampAndData()
   {
      ApiResponse<List<UserDto>> resp = controller.generateUsers(2, true);
      assertNotNull(resp.timestamp());
      assertEquals(2, resp.data().size());
   }

   @Test
   void generateUsersWithDataFakerReturnsTimestampAndData()
   {
      ApiResponse<List<UserDto>> resp = controller.generateUsers(2, false);
      assertNotNull(resp.timestamp());
      assertEquals(2, resp.data().size());
   }
}
