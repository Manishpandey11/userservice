package com.scaler.userservice.controlers;

import com.scaler.userservice.dtos.LogOutRequestDto;
import com.scaler.userservice.dtos.LoginRequestDto;
import com.scaler.userservice.dtos.SignUpRequestDto;
import com.scaler.userservice.dtos.UserDto;
import com.scaler.userservice.models.Token;
import com.scaler.userservice.models.User;
import com.scaler.userservice.services.UserService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

@PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto request){

        return userService.login(request.getEmail(),request.getPassword());
    }
    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpRequestDto request){
        String email = request.getEmail();
        String password = request.getPassword();
        String name = request.getName();;

        return UserDto.from(userService.signUp(name,email,password));
    }

@PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogOutRequestDto request){
    userService.logout(request.getToken());
    return new ResponseEntity<>(HttpStatus.OK);

        //return  null;
    }
    @PostMapping("/validate/{token}")
    public UserDto validateToken(@PathVariable("token") @NonNull  String token) {
        return UserDto.from(userService.validateToken(token));
    }
}
