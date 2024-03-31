package Dao;

import Model.Question;
import Model.UserModel.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList;
    private UserDao() {
        userList = new ArrayList<>();
    }
    private static class Holder {
        private static UserDao INSTANCE = new UserDao();
    }
    public static UserDao getInstance() {
        return UserDao.Holder.INSTANCE;
    }
    public void addUser(User user) {
        userList.add(user);
    }
}
