package com.example.articlesportal.service;

import com.example.articlesportal.dto.LoginDto;
import com.example.articlesportal.dto.UserDto;
import com.example.articlesportal.entity.Privilege;
import com.example.articlesportal.entity.User;
import com.example.articlesportal.exception.ArticleAPIException;
import com.example.articlesportal.repository.PrivilegeRepository;
import com.example.articlesportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PrivilegeRepository privilegeRepository;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public String userLogin(LoginDto loginDto) {

        Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User logged in successfully";
    }

    public String registerUser(UserDto userDto) {
//        if ( !usernameAlreadyExists(userDto)) {
//            throw new ArticleAPIException(HttpStatus.BAD_REQUEST, "Username already exists");
//        }
//        if ( !emailAlreadyExists(userDto)) {
//            throw new ArticleAPIException(HttpStatus.BAD_REQUEST, "Email already exists");
//        }
        if ( !usernameAlreadyExists(userDto) && !emailAlreadyExists(userDto)){

            User user = mapToEntity(userDto);
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            Set<Privilege> privileges = new HashSet<>();
            Privilege userPrivilege = this.privilegeRepository.findByName("ROLE_USER").get();
            privileges.add(userPrivilege);
            user.setPrivileges(privileges);

            this.userRepository.save(user);

            return "User registered successfully";
        } else {
            throw new ArticleAPIException(HttpStatus.BAD_REQUEST, "User already exists");
        }
    }


    // mapping
    private UserDto mapToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
    private User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
    // helpers
    public boolean usernameAlreadyExists(UserDto userDto) {
        return this.userRepository.existsByUsername(userDto.getUsername());
    }
    public boolean emailAlreadyExists(UserDto userDto) {
        return this.userRepository.existsByEmail(userDto.getEmail());
    }
}
