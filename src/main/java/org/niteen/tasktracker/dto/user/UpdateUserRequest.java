package org.niteen.tasktracker.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.niteen.tasktracker.enums.Role;

public class UpdateUserRequest {

    @NotBlank(message = "name is rquired")
    private String name;

    @NotBlank(message = "email is Required ")
    private String email;

    @NotBlank(message = "password cannot be empty")
    @Size(min = 8, message = "Password must be atleast 8 charachters")
    private String password;


    public UpdateUserRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    public UpdateUserRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
