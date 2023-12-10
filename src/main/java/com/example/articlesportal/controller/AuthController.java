package com.example.articlesportal.controller;

import com.example.articlesportal.dto.LoginDto;
import com.example.articlesportal.dto.UserDto;
import com.example.articlesportal.entity.User;
import com.example.articlesportal.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @GetMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody @Valid LoginDto loginDto) {
        String response = this.userService.userLogin(loginDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<String> registerNewUser(@RequestBody @Valid UserDto userDto){
        String response = this.userService.registerUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/logout")
//    @PreAuthorize("isAuthenticated()") --> for any logged in user
    public void userLogout() {
        // logout user
    }

}
