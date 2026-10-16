package com.challenge.ToolShare.service;

import org.springframework.stereotype.Service;
import com.challenge.ToolShare.dto.UserResponse;
import com.challenge.ToolShare.dto.UserRequest;
import com.challenge.ToolShare.entity.User;
import com.challenge.ToolShare.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createUser(UserRequest request) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setNeighborhood(request.getNeighborhood());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" +id));

        return mapToResponse(user);
    }

    public UserResponse updateUser(Long id, UserRequest request) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found with id:" +id));

        existingUser.setFirstName(request.getFirstName());
        existingUser.setLastName(request.getLastName());
        existingUser.setEmail(request.getEmail());
        existingUser.setNeighborhood(request.getNeighborhood());

        User updatedUser = userRepository.save(existingUser);

        return mapToResponse(updatedUser);
    }

    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id:" +id);
        }
        userRepository.deleteById(id);
    }



    public UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setNeighborhood(user.getNeighborhood());

        return response;
    }

}
