package repository;


import domain.entities.User;
import repository.GenericRepository;

import java.util.List;

public interface UserRepository extends GenericRepository<User, String> {
    User findByUsername(String username);

    void deleteFriend(String id, String userId);
}
