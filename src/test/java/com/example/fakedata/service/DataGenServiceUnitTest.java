package com.example.fakedata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.fakedata.domain.User;

/**
 * Unit tests for DataGenService without Spring context.
 * These tests are faster as they don't load the Spring application context.
 */
class DataGenServiceUnitTest
{
   private DataGenService dataGenService;

   @BeforeEach
   void setUp()
   {
      dataGenService = new DataGenService();
   }

   @Test
   void randomUserViaDatafakerGeneratesValidUser()
   {
      User user = dataGenService.randomUserViaDatafaker();

      assertNotNull(user, "User should not be null");
      assertNotNull(user.getId(), "User ID should not be null");
      assertFalse(user.getId().isBlank(), "User ID should not be blank");
      assertNotNull(user.getFullName(), "User full name should not be null");
      assertFalse(user.getFullName().isBlank(), "User full name should not be blank");
      assertNotNull(user.getEmail(), "User email should not be null");
      assertTrue(user.getEmail().contains("@"), "User email should contain @");
      assertNotNull(user.getPhone(), "User phone should not be null");
      assertFalse(user.getPhone().isBlank(), "User phone should not be blank");
      assertNotNull(user.getAddress(), "User address should not be null");
      assertFalse(user.getAddress().isBlank(), "User address should not be blank");
   }

   @Test
   void randomUserViaDatafakerGeneratesUniqueUsers()
   {
      User user1 = dataGenService.randomUserViaDatafaker();
      User user2 = dataGenService.randomUserViaDatafaker();

      assertNotNull(user1, "First user should not be null");
      assertNotNull(user2, "Second user should not be null");
      assertFalse(user1.getId().equals(user2.getId()), "User IDs should be unique");
   }

   @Test
   void randomUserViaDatafakerGeneratesValidEmail()
   {
      User user = dataGenService.randomUserViaDatafaker();

      assertNotNull(user.getEmail());
      assertTrue(user.getEmail().matches("^[^@]+@[^@]+\\.[^@]+$"), 
            "Email should match basic email pattern");
   }

   @Test
   void randomUserViaEasyRandomGeneratesValidUser()
   {
      User user = dataGenService.randomUserViaEasyRandom();

      assertNotNull(user, "User should not be null");
      assertNotNull(user.getId(), "User ID should not be null");
      assertFalse(user.getId().isBlank(), "User ID should not be blank");
      assertNotNull(user.getFullName(), "User full name should not be null");
      assertFalse(user.getFullName().isBlank(), "User full name should not be blank");
      assertNotNull(user.getEmail(), "User email should not be null");
      assertTrue(user.getEmail().contains("@"), "User email should contain @");
   }

   @Test
   void randomUserViaEasyRandomGeneratesUniqueUsers()
   {
      User user1 = dataGenService.randomUserViaEasyRandom();
      User user2 = dataGenService.randomUserViaEasyRandom();

      assertNotNull(user1, "First user should not be null");
      assertNotNull(user2, "Second user should not be null");
      assertFalse(user1.getId().equals(user2.getId()), "User IDs should be unique");
   }

   @Test
   void randomUserViaEasyRandomGeneratesValidEmail()
   {
      User user = dataGenService.randomUserViaEasyRandom();

      assertNotNull(user.getEmail());
      assertTrue(user.getEmail().matches("^[^@]+@[^@]+\\.[^@]+$"), 
            "Email should match basic email pattern");
   }

   @Test
   void manyUsersWithDatafakerReturnsCorrectCount()
   {
      int count = 5;
      List<User> users = dataGenService.manyUsers(count, false);

      assertNotNull(users, "Users list should not be null");
      assertEquals(count, users.size(), "Should generate exactly " + count + " users");

      users.forEach(user -> {
         assertNotNull(user, "Each user should not be null");
         assertNotNull(user.getId(), "Each user ID should not be null");
         assertNotNull(user.getFullName(), "Each user full name should not be null");
         assertNotNull(user.getEmail(), "Each user email should not be null");
      });
   }

   @Test
   void manyUsersWithEasyRandomReturnsCorrectCount()
   {
      int count = 5;
      List<User> users = dataGenService.manyUsers(count, true);

      assertNotNull(users, "Users list should not be null");
      assertEquals(count, users.size(), "Should generate exactly " + count + " users");

      users.forEach(user -> {
         assertNotNull(user, "Each user should not be null");
         assertNotNull(user.getId(), "Each user ID should not be null");
         assertNotNull(user.getFullName(), "Each user full name should not be null");
         assertNotNull(user.getEmail(), "Each user email should not be null");
      });
   }

   @Test
   void manyUsersWithZeroCountReturnsEmptyList()
   {
      List<User> users = dataGenService.manyUsers(0, false);

      assertNotNull(users, "Users list should not be null");
      assertTrue(users.isEmpty(), "Users list should be empty for count 0");
   }

   @Test
   void manyUsersWithNegativeCountReturnsEmptyList()
   {
      List<User> users = dataGenService.manyUsers(-5, false);

      assertNotNull(users, "Users list should not be null");
      assertTrue(users.isEmpty(), "Users list should be empty for negative count");
   }

   @Test
   void manyUsersGeneratesUniqueIdsWithDatafaker()
   {
      int count = 10;
      List<User> users = dataGenService.manyUsers(count, false);

      assertNotNull(users);
      assertEquals(count, users.size());

      long uniqueIds = users.stream()
            .map(User::getId)
            .distinct()
            .count();

      assertEquals(count, uniqueIds, "All user IDs should be unique");
   }

   @Test
   void manyUsersGeneratesUniqueIdsWithEasyRandom()
   {
      int count = 10;
      List<User> users = dataGenService.manyUsers(count, true);

      assertNotNull(users);
      assertEquals(count, users.size());

      long uniqueIds = users.stream()
            .map(User::getId)
            .distinct()
            .count();

      assertEquals(count, uniqueIds, "All user IDs should be unique");
   }

   @Test
   void manyUsersWithLargeCountGeneratesCorrectly()
   {
      int count = 100;
      List<User> users = dataGenService.manyUsers(count, false);

      assertNotNull(users);
      assertEquals(count, users.size(), "Should handle large counts correctly");
   }

   @Test
   void randomUserViaDatafakerHasAllFieldsPopulated()
   {
      User user = dataGenService.randomUserViaDatafaker();

      assertNotNull(user.getId());
      assertNotNull(user.getFullName());
      assertNotNull(user.getEmail());
      assertNotNull(user.getPhone());
      assertNotNull(user.getAddress());
      
      assertTrue(user.getId().length() > 0);
      assertTrue(user.getFullName().length() > 0);
      assertTrue(user.getEmail().length() > 0);
      assertTrue(user.getPhone().length() > 0);
      assertTrue(user.getAddress().length() > 0);
   }

   @Test
   void randomUserViaEasyRandomHasRequiredFieldsPopulated()
   {
      User user = dataGenService.randomUserViaEasyRandom();

      assertNotNull(user.getId());
      assertNotNull(user.getFullName());
      assertNotNull(user.getEmail());
      
      assertTrue(user.getId().length() > 0);
      assertTrue(user.getFullName().length() > 0);
      assertTrue(user.getEmail().length() > 0);
   }
}

