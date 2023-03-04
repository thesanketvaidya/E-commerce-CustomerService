package com.customermanagement.security.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 
@NoArgsConstructor
@Setter
@Getter
public class JwtResponseModel implements Serializable {
   /**
   *
   */
   private static final long serialVersionUID = 1L;
   private String token;
   private String role;
   
   public JwtResponseModel(String token,String role) {
      this.token = token;
      this.role=role;
   }
   
}