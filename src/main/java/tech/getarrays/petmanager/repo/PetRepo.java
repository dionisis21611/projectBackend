package tech.getarrays.petmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.User;

import java.util.List;
import java.util.Optional;

public interface PetRepo extends JpaRepository<Pet, Long> {
    void deletePetById(Long id);

    @Query("SELECT e FROM Pet e WHERE (accept = true) ")
    List<Pet> findAllAcceptedPets();

    Optional<Pet> findPetById(Long id);
    }
