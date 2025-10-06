package com.example.fakedata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fakedata.domain.User;

@SpringBootTest
class DataGenServiceTest
{
   @Autowired
   private DataGenService dataGenService;

   @Test
   void randomUserViaDatafakerGeneratesValidUser()
   {
      User user = dataGenService.randomUserViaDatafaker();

      assertNotNull(user);
      assertNotNull(user.getId());
      assertFalse(user.getId().isBlank());
      assertNotNull(user.getFullName());
      assertFalse(user.getFullName().isBlank());
      assertNotNull(user.getEmail());
      assertTrue(user.getEmail().contains("@"));
      assertNotNull(user.getPhone());
      assertFalse(user.getPhone().isBlank());
      assertNotNull(user.getAddress());
      assertFalse(user.getAddress().isBlank());
   }

   @Test
   void randomUserViaDatafakerGeneratesUniqueUsers()
   {
      User user1 = dataGenService.randomUserViaDatafaker();
      User user2 = dataGenService.randomUserViaDatafaker();

      assertNotNull(user1);
      assertNotNull(user2);
      assertFalse(user1.getId().equals(user2.getId()));
   }

   @Test
   void randomUserViaEasyRandomGeneratesValidUser()
   {
      User user = dataGenService.randomUserViaEasyRandom();

      assertNotNull(user);
      assertNotNull(user.getId());
      assertFalse(user.getId().isBlank());
      assertNotNull(user.getFullName());
      assertFalse(user.getFullName().isBlank());
      assertNotNull(user.getEmail());
      assertTrue(user.getEmail().contains("@"));
   }

   @Test
   void randomUserViaEasyRandomGeneratesUniqueUsers()
   {
      User user1 = dataGenService.randomUserViaEasyRandom();
      User user2 = dataGenService.randomUserViaEasyRandom();

      assertNotNull(user1);
      assertNotNull(user2);
      assertFalse(user1.getId().equals(user2.getId()));
   }

   @Test
   void manyUsersWithDatafakerReturnsCorrectCount()
   {
      int count = 5;
      List<User> users = dataGenService.manyUsers(count, false);

      assertNotNull(users);
      assertEquals(count, users.size());

      users.forEach(user -> {
         assertNotNull(user);
         assertNotNull(user.getId());
         assertNotNull(user.getFullName());
         assertNotNull(user.getEmail());
      });
   }

   @Test
   void manyUsersWithEasyRandomReturnsCorrectCount()
   {
      int count = 5;
      List<User> users = dataGenService.manyUsers(count, true);

      assertNotNull(users);
      assertEquals(count, users.size());

      users.forEach(user -> {
         assertNotNull(user);
         assertNotNull(user.getId());
         assertNotNull(user.getFullName());
         assertNotNull(user.getEmail());
      });
   }

   @Test
   void manyUsersWithZeroCountReturnsEmptyList()
   {
      List<User> users = dataGenService.manyUsers(0, false);

      assertNotNull(users);
      assertTrue(users.isEmpty());
   }

   @Test
   void manyUsersWithNegativeCountReturnsEmptyList()
   {
      List<User> users = dataGenService.manyUsers(-5, false);

      assertNotNull(users);
      assertTrue(users.isEmpty());
   }

   @Test
   void manyUsersGeneratesUniqueIds()
   {
      int count = 10;
      List<User> users = dataGenService.manyUsers(count, false);

      assertNotNull(users);
      assertEquals(count, users.size());

      long uniqueIds = users.stream()
            .map(User::getId)
            .distinct()
            .count();

      assertEquals(count, uniqueIds);
   }
}

