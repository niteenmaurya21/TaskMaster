package org.niteen.tasktracker.mapper;

import org.niteen.tasktracker.dto.user.RegisterRequest;
import org.niteen.tasktracker.dto.user.UserDTO;
import org.niteen.tasktracker.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDto(User user) {

        if(user == null) return null;
        UserDTO dto = new UserDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());

        return dto;
    }

    public User toEntity(RegisterRequest request) {

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return user;
    }
}
