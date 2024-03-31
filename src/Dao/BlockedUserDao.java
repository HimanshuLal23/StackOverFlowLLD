package Dao;

import Model.UserModel.User;

import java.util.HashSet;
import java.util.Set;

import Exception.*;
import Model.UserModel.UserType;

public class BlockedUserDao {
    private Set<User> blockedUserSet;
    private BlockedUserDao() {
        blockedUserSet = new HashSet<>();
    }
    private static class Holder {
        private static BlockedUserDao blockedUserDao = new BlockedUserDao();
    }
    public static BlockedUserDao getInstance() {
        return Holder.blockedUserDao;
    }
    public void blockUser(User userToBlocked,User user) throws SOFException {
        if(user.getUserType() != UserType.Admin) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You are not allowed to block the user");
        }
        blockedUserSet.add(userToBlocked);
    }
    public void unBlockUser(User userToUnBlocked,User user) throws SOFException {
        if(user.getUserType() != UserType.Admin) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You are not allowed to un-block the user");
        }
        blockedUserSet.remove(userToUnBlocked);
    }
    public boolean isUserBlocked(User userToBeChecked,User user) throws SOFException {
        if(user.getUserType() != UserType.Admin) {
            throw new SOFException(SOFExceptionType.InsufficientException,"You are not allowed to search for blocked user");
        }
        return blockedUserSet.contains(userToBeChecked);
    }
}
