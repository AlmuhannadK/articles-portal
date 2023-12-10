package com.example.articlesportal.controller;

import com.example.articlesportal.dto.LoginDto;
import com.example.articlesportal.dto.UserDto;
import com.example.articlesportal.entity.User;
import com.example.articlesportal.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto){ //@valid validate new user
        //save user in repo
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDto loginDto) { //@Valid validate user credentials
        String response = this.userService.userLogin(loginDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/logout")
//    @PreAuthorize("isAuthenticated()") --> for any logged in user
    public void userLogout() {
        // logout user
    }

}
