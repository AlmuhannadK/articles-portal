package com.example.articlesportal.service;

import com.example.articlesportal.dto.UserDto;
import com.example.articlesportal.entity.User;
import com.example.articlesportal.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;







//    //convert Entity to Dto
    private UserDto mapToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
    //convert Dto to Entity
    private User mapToEntity(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }
}
