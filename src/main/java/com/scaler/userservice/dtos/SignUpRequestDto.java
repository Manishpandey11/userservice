package com.scaler.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SingUpRequestDto {
    private String email;
    private String password;
    private String name;

}
