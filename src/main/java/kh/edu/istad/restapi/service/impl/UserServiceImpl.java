package kh.edu.istad.restapi.service.impl;

import kh.edu.istad.restapi.dto.CreateUserRequest;
import kh.edu.istad.restapi.model.User;
import kh.edu.istad.restapi.repository.UserRepository;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.selectAll();
    }

    @Override
    public User getById(UUID id) {
        return userRepository.selectById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found with ID: " + id
                ));
    }

    @Override
    public User create(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername(createUserRequest.username());
        user.setPassword(createUserRequest.password());
        user.setEmail(createUserRequest.email());
        user.setIsActive(true);

        return userRepository.insert(user);
    }

    @Override
    public void deleteById(UUID id) {
        boolean isDeleted = userRepository.deleteById(id);
        if (!isDeleted) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "User not found with ID: " + id
            );
        }
    }
}
