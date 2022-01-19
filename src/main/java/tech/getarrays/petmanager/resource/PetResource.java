package tech.getarrays.petmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.Role;
import tech.getarrays.petmanager.model.User;
import tech.getarrays.petmanager.model.UserPet;
import tech.getarrays.petmanager.repo.*;
import tech.getarrays.petmanager.service.PetService;
import tech.getarrays.petmanager.viewModel.PetViewModel;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetResource {
    private final PetService petService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PetRepo petRepo;
    @Autowired
    private UserPetRepo userPetRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;
    @Autowired
    private tech.getarrays.petmanager.resource.UserResource userResource;

    public PetResource(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Pet>> getAllPet () {
        List<Pet> pet;
        List<Role> roles = userRoleRepo.findByUserId(userResource.userLogin.getId());

        Role roleAdmin = roleRepo.findByDescription("Διαχειριστής");
        Role roleDoctor = roleRepo.findByDescription("Κτηνίατρος");
        Role roleEmployee = roleRepo.findByDescription("Δημοτικός υπάλληλος");
        if (roles == null) {
            roles.add(roleAdmin);
        }
        if (roles.contains(roleAdmin) || roles.contains(roleDoctor) ){
            pet = petService.findAllPet();
        }else if (roles.contains(roleEmployee)) {
//            pet = petRepo.findAllAcceptedPets();
            pet = userPetRepo.findAllAcceptedAndSameCityPets(userResource.userLogin.getCity());
        } else {
            pet = userPetRepo.findByUserId(userResource.userLogin.getId());
        }



        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Pet> getPetById (@PathVariable("id") Long id) {
        Pet pet = petService.findPetById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Pet> addPet(@RequestBody Pet pet) {
        User user1 = userResource.userLogin;
        Pet newPet = petService.addPet(pet);
        UserPet userPet = new UserPet(user1,newPet);
        this.userPetRepo.save(userPet);
        return new ResponseEntity<>(newPet, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
        Pet updatePet = petService.updatePet(pet);
        return new ResponseEntity<>(updatePet, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePet(@PathVariable("id") Long id) {
        Long userPetId = userPetRepo.findByUserIdAndPetId(userResource.userLogin.getId(), String.valueOf(id));
//        UserPet userPet = userPetRepo.findUserPetById(userPetId);

       //  userPetRepo.deleteByIdAndUserAndPet(userPetId,userResource.userLogin,petRepo.findPetById(id));

       petService.deletePet(id);
  //      userPetRepo.deleteUserPetById(userPetId);
//      userPetRepo.delete(userPet);

//       userPetRepo.deleteUserPetsById(userPetId);
//        userPetRepo.deleteById(userPetId);


        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/findByUser/{id}")
    public ResponseEntity<List<Pet>> getPetByUserId (@PathVariable("id") String id) {
        List<Pet> pets = userPetRepo.findByUserId(id);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}
