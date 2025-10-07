package com.example.fakedata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;

/**
 * Standalone tests for DataFaker with various locales. Tests different locales to verify that locale-specific data is generated
 * correctly. Does not use User objects or DTOs - just pure DataFaker tests.
 */
@Slf4j
class DataFakerLocaleTest
{
   /**
    * Record to hold user data with country and locale information
    */
   record MyUser(String name, String address, String city, String country, Locale locale) {
   }

   @Test
   void testEnglishUSLocale()
   {
      Faker faker = new Faker(Locale.US);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String city = faker.address().city();
      String country = faker.address().country();

      MyUser user = new MyUser(name, address, city, country, Locale.US);
      log.info("US Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);

      assertFalse(name.isBlank());
      assertFalse(address.isBlank());
   }

   @Test
   void testCanadaLocale()
   {
      Faker faker = new Faker(Locale.CANADA);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String province = faker.address().state();

      MyUser user = new MyUser(name, address, province, country, Locale.CANADA);
      log.info("Canada Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(country);
      assertNotNull(province);
   }

   @Test
   void testBrazilianPortugueseLocale()
   {
      Locale locale = Locale.of("pt", "BR");
      Faker faker = new Faker(locale);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String city = faker.address().city();
      String country = faker.address().country();

      MyUser user = new MyUser(name, address, city, country, locale);
      log.info("Brazilian Portuguese Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testFrenchLocale()
   {
      Faker faker = new Faker(Locale.FRENCH);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String city = faker.address().city();

      MyUser user = new MyUser(name, address, city, country, Locale.FRENCH);
      log.info("French Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testGermanLocale()
   {
      Faker faker = new Faker(Locale.GERMAN);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String city = faker.address().city();

      MyUser user = new MyUser(name, address, city, country, Locale.GERMAN);
      log.info("German Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testItalianLocale()
   {
      Faker faker = new Faker(Locale.ITALIAN);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String city = faker.address().city();

      MyUser user = new MyUser(name, address, city, country, Locale.ITALIAN);
      log.info("Italian Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testSpanishSpainLocale()
   {
      Locale locale = Locale.of("es", "ES");
      Faker faker = new Faker(locale);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String city = faker.address().city();

      MyUser user = new MyUser(name, address, city, country, locale);
      log.info("Spanish Spain Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testSpanishMexicoLocale()
   {
      Locale locale = Locale.of("es", "MX");
      Faker faker = new Faker(locale);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String city = faker.address().city();

      MyUser user = new MyUser(name, address, city, country, locale);
      log.info("Spanish Mexico Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testJapaneseLocale()
   {
      Faker faker = new Faker(Locale.JAPANESE);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();
      String city = faker.address().city();

      MyUser user = new MyUser(name, address, city, country, Locale.JAPANESE);
      log.info("Japanese Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(city);
      assertNotNull(country);
   }

   @Test
   void testChineseLocale()
   {
      Faker faker = new Faker(Locale.CHINESE);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();

      MyUser user = new MyUser(name, address, "", country, Locale.CHINESE);
      log.info("Chinese Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(country);
   }

   @Test
   void testRussianLocale()
   {
      Locale locale = Locale.of("ru", "RU");
      Faker faker = new Faker(locale);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();

      MyUser user = new MyUser(name, address, "", country, locale);
      log.info("Russian Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(country);
   }

   @Test
   void testUKLocale()
   {
      Faker faker = new Faker(Locale.UK);

      String name = faker.name().fullName();
      String address = faker.address().fullAddress();
      String country = faker.address().country();

      MyUser user = new MyUser(name, address, "", country, Locale.UK);
      log.info("UK Locale User: {}", user);

      assertNotNull(name);
      assertNotNull(address);
      assertNotNull(country);
   }

   @Test
   void testPhoneNumbersVaryByLocale()
   {
      Faker usFaker = new Faker(Locale.US);
      Faker brFaker = new Faker(Locale.of("pt", "BR"));
      Faker deFaker = new Faker(Locale.GERMAN);

      String usPhone = usFaker.phoneNumber().phoneNumber();
      String brPhone = brFaker.phoneNumber().phoneNumber();
      String dePhone = deFaker.phoneNumber().phoneNumber();

      log.info("US Phone: {}, BR Phone: {}, DE Phone: {}", usPhone, brPhone, dePhone);

      assertNotNull(usPhone);
      assertNotNull(brPhone);
      assertNotNull(dePhone);

      assertFalse(usPhone.isBlank());
      assertFalse(brPhone.isBlank());
      assertFalse(dePhone.isBlank());
   }

   @Test
   void testEmailsAreValidForAllLocales()
   {
      Locale[] locales = {
            Locale.US, Locale.CANADA, Locale.of("pt", "BR"), Locale.FRENCH,
            Locale.GERMAN, Locale.ITALIAN, Locale.of("es", "ES"), Locale.JAPANESE
      };

      for (Locale locale : locales)
      {
         Faker faker = new Faker(locale);
         String email = faker.internet().emailAddress();

         log.info("Locale: {}, Email: {}", locale, email);

         assertNotNull(email);
         assertTrue(email.contains("@"), "Email should contain @ for locale: " + locale);
         assertTrue(email.matches("^[^@]+@[^@]+\\.[^@]+$"),
               "Email should be valid format for locale: " + locale + ", but got: " + email);
      }
   }

   @Test
   void testCompanyNamesVaryByLocale()
   {
      Faker usFaker = new Faker(Locale.US);
      Faker jpFaker = new Faker(Locale.JAPANESE);
      Faker deFaker = new Faker(Locale.GERMAN);

      String usCompany = usFaker.company().name();
      String jpCompany = jpFaker.company().name();
      String deCompany = deFaker.company().name();

      log.info("US Company: {}, JP Company: {}, DE Company: {}", usCompany, jpCompany, deCompany);

      assertNotNull(usCompany);
      assertNotNull(jpCompany);
      assertNotNull(deCompany);

      assertFalse(usCompany.isBlank());
      assertFalse(jpCompany.isBlank());
      assertFalse(deCompany.isBlank());
   }

   @Test
   void testCityNamesVaryByLocale()
   {
      Faker usFaker = new Faker(Locale.US);
      Faker brFaker = new Faker(Locale.of("pt", "BR"));
      Faker frFaker = new Faker(Locale.FRENCH);

      String usCity = usFaker.address().city();
      String brCity = brFaker.address().city();
      String frCity = frFaker.address().city();

      log.info("US City: {}, BR City: {}, FR City: {}", usCity, brCity, frCity);

      assertNotNull(usCity);
      assertNotNull(brCity);
      assertNotNull(frCity);

      assertFalse(usCity.isBlank());
      assertFalse(brCity.isBlank());
      assertFalse(frCity.isBlank());
   }

   @Test
   void testStreetAddressesVaryByLocale()
   {
      Faker usFaker = new Faker(Locale.US);
      Faker deFaker = new Faker(Locale.GERMAN);
      Faker itFaker = new Faker(Locale.ITALIAN);

      String usStreet = usFaker.address().streetAddress();
      String deStreet = deFaker.address().streetAddress();
      String itStreet = itFaker.address().streetAddress();

      log.info("US Street: {}, DE Street: {}, IT Street: {}", usStreet, deStreet, itStreet);

      assertNotNull(usStreet);
      assertNotNull(deStreet);
      assertNotNull(itStreet);

      assertFalse(usStreet.isBlank());
      assertFalse(deStreet.isBlank());
      assertFalse(itStreet.isBlank());
   }
}
