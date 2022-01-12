package tech.getarrays.petmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.petmanager.exception.UserNotFoundException;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.repo.PetRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PetService {
    private final PetRepo petRepo;

    @Autowired
    public PetService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public Pet addPet(Pet pet) {
        pet.setPetCode(UUID.randomUUID().toString());
        return petRepo.save(pet);
    }

    public List<Pet> findAllPet() {
        return petRepo.findAll();
    }

    public Pet updatePet(Pet pet) {
        return petRepo.save(pet);
    }

    public Pet findPetById(Long id) {
        return petRepo.findPetById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePet(Long id){
        petRepo.deletePetById(id);
    }
}
