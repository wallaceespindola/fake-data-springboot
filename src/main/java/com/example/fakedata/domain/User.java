package com.example.fakedata.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User
{
   private String id;
   private String fullName;
   private String email;
   private String phone;
   private String address;
}
