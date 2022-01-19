package tech.getarrays.petmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petmanager.exception.ResourceNotFoundException;
import tech.getarrays.petmanager.model.Role;
import tech.getarrays.petmanager.model.User;
import tech.getarrays.petmanager.model.UserRole;
import tech.getarrays.petmanager.repo.RoleRepo;
import tech.getarrays.petmanager.repo.UserRepo;
import tech.getarrays.petmanager.repo.UserRoleRepo;
import tech.getarrays.petmanager.viewModel.ResponseMessage;
import tech.getarrays.petmanager.viewModel.RoleViewModel;
import tech.getarrays.petmanager.viewModel.UserRoleViewModel;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/userRoles")
public class UserRoleResource {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private RoleRepo roleRepo;


    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody UserRoleViewModel userRoleViewModel) {


        User user = new User(userRoleViewModel.getName(), userRoleViewModel.getUsername(), userRoleViewModel.getEmail(), userRoleViewModel.getPassword(), userRoleViewModel.getPhone(), userRoleViewModel.getCity());

        this.userRepo.save(user);

        HashMap<String, HashSet<Date[]>> datesRoles = userRoleViewModel.getRoles();


        Set set = datesRoles.entrySet();

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {

            Map.Entry mentry = (Map.Entry) iterator.next();


            HashSet<Date[]> hashSet = (HashSet<Date[]>) mentry.getValue();

            for (Date[] date : hashSet) {

                UserRole userRole = new UserRole();
                Role role = this.roleRepo.findById(mentry.getKey().toString()).orElse(null);
                userRole.setUser(user);
                userRole.setRole(role);
                this.userRoleRepo.save(userRole);

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
