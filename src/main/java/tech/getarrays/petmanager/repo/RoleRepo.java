package tech.getarrays.petmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.petmanager.Side.RoleName;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, String> {
    Optional<Role> findByName(RoleName roleName);
    Role findByDescription(String description);
}
