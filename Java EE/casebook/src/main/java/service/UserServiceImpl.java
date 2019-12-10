package service;

import domain.entities.User;
import domain.models.service.UserServiceModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import repository.UserRepository;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Inject
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel getUserByUsername(String username) {
        return this.modelMapper.map(this.userRepository.findByUsername(username), UserServiceModel.class);
    }

    @Override
    public UserServiceModel createUser(UserServiceModel userServiceModel) {
        userServiceModel.setPassword(DigestUtils.sha256Hex(userServiceModel.getPassword()));
        return this.modelMapper.map(
                this.userRepository
                        .save(this.modelMapper.map(userServiceModel, User.class)),
                UserServiceModel.class);
    }

    @Override
    public UserServiceModel getUserById(String id) {
        User user = this.userRepository.findById(id);

        if (user == null) {
            return null;
        }

        return this.modelMapper.map(user, UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> getAllUsers() {
        return this.userRepository
                .findAll()
                .stream()
                .map(u-> this.modelMapper.map(u,UserServiceModel.class ))
                .collect(Collectors.toList());
    }

    @Override
    public boolean addFriend(UserServiceModel loggedInUser) {
        User user = this.userRepository.update(this.modelMapper.map(loggedInUser, User.class));

        if (user != null) {
            return true;
        }
        return false;
    }


    @Override
    public void deleteFriends(String loggedInUserId, String userId){
        this.userRepository.deleteFriend(loggedInUserId, userId);
        this.userRepository.deleteFriend(userId, loggedInUserId);
        System.out.println("Tuk sam v servica");
    }
}
