package tech.getarrays.petmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.User;
import tech.getarrays.petmanager.model.UserPet;

import java.util.List;
import java.util.Optional;

public interface UserPetRepo extends JpaRepository<UserPet, String> {
    @Query("SELECT e.pet FROM UserPet e WHERE user_id LIKE %?1% ")
    List<Pet> findByUserId(String id);

    @Query("SELECT e.id FROM UserPet e WHERE user_id LIKE %?1% AND pet_id LIKE %?2%")
    Long findByUserIdAndPetId(String userId,String petId);

    @Query("SELECT e.pet FROM UserPet e WHERE e.user.city LIKE ?1 AND (e.pet.accept = true)")
    List<Pet> findAllAcceptedAndSameCityPets(String city);

    void deleteUserPetById(Long id);
//    @Query("DELETE FROM UserPet WHERE (id = ?1) ")
//    void deleteById(String ID);
// void deleteByIdAndUserAndPet(String id, User user, Optional<Pet> pet);
////   void delete(Optional<UserPet> byId);
//    //void deleteById(String id);
//    void deleteUserPetsById(String id);
//   UserPet findUserPetById(String id);
//
//    @Override
//    void delete(UserPet userPet);
}
