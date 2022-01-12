package tech.getarrays.petmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, String> {
     void deleteUserById(String id);
    @Query("SELECT e FROM User e WHERE username LIKE ?1 AND password LIKE ?2")
    User findByUsernameAndPassword(String username,String password);

    Optional<User> findUserById(String id);
}
