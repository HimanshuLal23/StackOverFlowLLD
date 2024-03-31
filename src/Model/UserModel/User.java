package Model.UserModel;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String username;
    private UserType userType;

    public User(String name, String email, String username, UserType userType) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.username = username;
        this.userType = userType;
    }

    public User() {
        this.id = UUID.randomUUID();
        this.userType = UserType.Guest;
    }
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public UserType getUserType() {
        return userType;
    }
}
