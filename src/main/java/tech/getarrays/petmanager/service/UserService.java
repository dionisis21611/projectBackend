package tech.getarrays.petmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.petmanager.exception.UserNotFoundException;
import tech.getarrays.petmanager.model.User;
import tech.getarrays.petmanager.repo.UserRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

//    public User addUser(User user) {
//        user.setUserCode(UUID.randomUUID().toString());
//        return userRepo.save(user);
//    }

    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user) ;
    }

    public User findUserById(String id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteUser(String id){
        userRepo.deleteUserById(id);
    }
}
