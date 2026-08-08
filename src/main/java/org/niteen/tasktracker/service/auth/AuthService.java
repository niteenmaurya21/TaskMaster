package org.niteen.tasktracker.service.auth;

import org.niteen.tasktracker.dto.user.LoginRequest;
import org.niteen.tasktracker.dto.user.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
