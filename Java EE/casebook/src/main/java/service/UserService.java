package service;

import domain.models.service.UserServiceModel;

import java.util.List;

public interface UserService {
    UserServiceModel getUserByUsername(String username);
    UserServiceModel createUser(UserServiceModel userServiceModel);
    UserServiceModel getUserById(String id);
    List<UserServiceModel> getAllUsers();
    boolean addFriend(UserServiceModel loggedInUser);
    void deleteFriends(String loggedInUserId, String userId);
}
