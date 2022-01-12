package tech.getarrays.petmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.petmanager.Side.RoleName;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.Role;
import tech.getarrays.petmanager.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface UserRoleRepo extends JpaRepository<UserRole, String> {
// Optional<Role> findByName(RoleName roleName);
@Query("SELECT e.role FROM UserRole e WHERE user_id LIKE %?1% ")
List<Role> findByUserId(String id);
}
