package tech.getarrays.petmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petmanager.model.*;
import tech.getarrays.petmanager.repo.*;
import tech.getarrays.petmanager.viewModel.ResponseMessage;
import tech.getarrays.petmanager.viewModel.UserPetViewModel;
import tech.getarrays.petmanager.viewModel.UserRoleViewModel;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/userPets")
public class UserPetResource {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserPetRepo userPetRepo;

    @Autowired
    private PetRepo petRepo;


    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody UserPetViewModel userPetViewModel) {

       User user = new User(userPetViewModel.getName(), userPetViewModel.getUsername(), userPetViewModel.getEmail(), userPetViewModel.getPassword(), userPetViewModel.getPhone(), userPetViewModel.getCity());
//
//        this.userRepo.save(user);

        HashMap<String, HashSet<Date[]>> datesPets = userPetViewModel.getPets();


        Set set = datesPets.entrySet();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {

            Map.Entry mentry = (Map.Entry) iterator.next();


            HashSet<Date[]> hashSet = (HashSet<Date[]>) mentry.getValue();

            for (Date[] date : hashSet) {

                UserPet userPet = new UserPet();
                Pet pet = this.petRepo.findById(Long.valueOf(mentry.getKey().toString())).orElse(null);
                userPet.setUser(user);
                userPet.setPet(pet);
                this.userPetRepo.save(userPet);

            }
//            private User convertToUserEntity(UserRoleViewModel viewModel) {
//
//
//
//                User entity = new User(viewModel.getName(), viewModel.getUsername(),viewModel.getEmail(),
//                        encoder.encode(viewModel.getPassword()));
//
//                return entity;
//            }
        }
        return new ResponseEntity<>(new ResponseMessage("User created successfully!"), HttpStatus.OK);
    }

}
