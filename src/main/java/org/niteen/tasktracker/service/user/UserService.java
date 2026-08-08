package org.niteen.tasktracker.service.user;

import org.niteen.tasktracker.dto.user.*;

import java.util.List;

public interface UserService {


        UserDTO register(RegisterRequest request);

//        LoginResponse login(LoginRequest request);

        UserDTO getUserById(Long id);

        List<UserDTO> getAllUsers();

        UserDTO updateUser(Long id, UpdateUserRequest request);

        void deleteUser(Long id);
    }

