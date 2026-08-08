package org.niteen.tasktracker.service.user;

import org.niteen.tasktracker.dto.user.*;
import org.niteen.tasktracker.entity.User;
import org.niteen.tasktracker.enums.Role;
import org.niteen.tasktracker.exception.EmailAlreadyExistsException;
import org.niteen.tasktracker.exception.UserNotFoundException;
import org.niteen.tasktracker.mapper.UserMapper;
import org.niteen.tasktracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = userMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.ROLE_USER);

        User savedUser = userRepository.save(user);

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException("User with id " + id + " not found"));
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()) {
            throw new UserNotFoundException("No users found");
        }

        //Using Streams

        return users.stream()
                .map(userMapper :: toDto)
                .toList();

    }

    @Override
    public UserDTO updateUser(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException("User with id " + id + " not found"));

        userRepository.findByEmail(request.getEmail())
                .ifPresent(existingUser -> {
                    if (!existingUser.getId().equals(id)) {
                        throw new EmailAlreadyExistsException("Email already exists.");
                    }
                });

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User updatedUser = userRepository.save(user);

        return userMapper.toDto(updatedUser) ;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()->
                new UserNotFoundException("User with id " + id + " not found"));

        userRepository.delete(user);

    }
}
