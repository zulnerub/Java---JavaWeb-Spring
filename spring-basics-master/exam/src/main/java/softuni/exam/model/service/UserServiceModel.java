package softuni.exam.model.service;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;

public class UserServiceModel {
    private String username;
    private String password;
    private String email;

    public UserServiceModel() {
    }

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false)
    @Length(min = 3, max = 20, message = "Password length must be between 3 and 20 characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email", nullable = false, unique = true)
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
