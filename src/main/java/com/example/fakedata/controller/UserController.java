package com.example.fakedata.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fakedata.api.ApiResponse;
import com.example.fakedata.dto.UserDto;
import com.example.fakedata.mapper.UserMapper;
import com.example.fakedata.service.DataGenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Users", description = "Fake user generation endpoints using Datafaker + EasyRandom")
public class UserController
{
   private final DataGenService service;

   public UserController(DataGenService service)
   {
      this.service = service;
   }

   @GetMapping("/{count}")
   @Operation(summary = "Generate N users (Datafaker by default)")
   public ApiResponse<List<UserDto>> generateUsers(
         @PathVariable int count, @RequestParam(name = "easy", defaultValue = "false") boolean easy)
   {
      return ApiResponse.of(
            service.manyUsers(count, easy).stream().map(UserMapper::toDto).collect(Collectors.toList()));
   }

   @GetMapping("/one")
   @Operation(summary = "Get a single user (Datafaker)")
   public ApiResponse<UserDto> one()
   {
      return ApiResponse.of(UserMapper.toDto(service.randomUserViaDatafaker()));
   }

   @PostMapping("/create/{count}")
   @Operation(summary = "POST to create N users (simulated). GET alternative provided.")
   public ApiResponse<List<UserDto>> createUsersPost(@PathVariable int count)
   {
      return ApiResponse.of(
            service.manyUsers(count, false).stream().map(UserMapper::toDto).collect(Collectors.toList()));
   }

   @GetMapping("/create/{count}")
   @Operation(summary = "GET alternative to POST create N users (simulated)")
   public ApiResponse<List<UserDto>> createUsersGet(@PathVariable int count)
   {
      return createUsersPost(count);
   }
}
