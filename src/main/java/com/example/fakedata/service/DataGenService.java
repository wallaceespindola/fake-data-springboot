package com.example.fakedata.service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Service;

import com.example.fakedata.domain.User;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

@Service
@Slf4j
public class DataGenService
{
   private final Faker faker = new Faker(Locale.ENGLISH);
   private final EasyRandom easyRandom = new EasyRandom(
         new EasyRandomParameters().seed(System.currentTimeMillis()).stringLengthRange(5, 20));

   public User randomUserViaDatafaker()
   {
      User u = User.builder() //
            .id(UUID.randomUUID().toString()) //
            .fullName(faker.name().fullName()) //
            .email(faker.internet().emailAddress()) //
            .phone(faker.phoneNumber().cellPhone()) //
            .address(faker.address().fullAddress()) //
            .build();
      log.info("Generated user via Datafaker: {}", u);
      return u;
   }

   public User randomUserViaEasyRandom()
   {
      User u = easyRandom.nextObject(User.class);
      if (u.getId() == null || u.getId().isBlank())
      {
         u.setId(UUID.randomUUID().toString());
      }
      u.setFullName(faker.name().fullName());
      u.setEmail(faker.internet().emailAddress());
      log.info("Generated user via EasyRandom: {}", u);
      return u;
   }

   public List<User> manyUsers(int count, boolean easy)
   {
      return IntStream.range(0, Math.max(0, count)).mapToObj(
            i -> easy ? randomUserViaEasyRandom() : randomUserViaDatafaker()).collect(Collectors.toList());
   }
}
