package Services.Notification;

import Model.UserModel.User;

import java.util.List;

public interface Subject {
    void notify(List<User> userList);
}
