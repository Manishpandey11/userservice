package com.scaler.userservice.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.SpringVersion;
@Getter
@Setter
public class LoginRequestDto {
    private String email;
    private String password;
}
