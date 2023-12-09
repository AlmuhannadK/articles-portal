package com.example.articlesportal.controller;

import com.example.articlesportal.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/user") // --> might need to use @RequestParam to send query params via url in angualr
    public ResponseEntity<User> registerNewUser(@RequestBody User user){ //@valid validate new user
        //save user in repo
        return ResponseEntity.ok(user);
    }

    @GetMapping("/login")
    public ResponseEntity<User> userLogin(@RequestBody User user) { //@Valid validate user credentials
        // if user exists, login
        return ResponseEntity.ok(user);
    }

    @GetMapping("/logout")
//    @PreAuthorize("isAuthenticated()") --> for any logged in user
    public void userLogout() {
        // logout user
    }

}
