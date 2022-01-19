package tech.getarrays.petmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petmanager.Side.RoleName;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.Role;
import tech.getarrays.petmanager.model.User;
import tech.getarrays.petmanager.model.UserRole;
import tech.getarrays.petmanager.repo.*;
import tech.getarrays.petmanager.service.UserService;
import tech.getarrays.petmanager.viewModel.RoleViewModel;
import tech.getarrays.petmanager.viewModel.UserViewModel;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/User")
public class UserResource {
    private final UserService userService;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserPetRepo userPetRepo;
    @Autowired
    private PetRepo PetRepo;
    @Autowired
    private UserRoleRepo userRoleRepo;

    public User userLogin;

    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public List<UserViewModel> all(){
        List<User> users = this.userService.findAllUsers();

        List<UserViewModel> userViewModel = users.stream().map(this::convertToUserViewModel).collect(Collectors.toList());
        return userViewModel;
    }
    private UserViewModel convertToUserViewModel(User entity) {
        UserViewModel viewModel = new UserViewModel();
        viewModel.setId(entity.getId());
        viewModel.setName(entity.getName());
        viewModel.setEmail(entity.getEmail());
        viewModel.setUsername(entity.getUsername());
        viewModel.setPassword(entity.getPassword());
        viewModel.setPhone(entity.getPhone());
        viewModel.setCity(entity.getCity());

        return viewModel;

    }
    // Get a Single User
    @GetMapping("/byId/{id}")
    public UserViewModel byId(@PathVariable String id) {
        User user = this.userRepo.findUserById(id).orElse(null);

        if (user == null) {
            throw new EntityNotFoundException();
        }

        UserViewModel userViewModel = this.convertToUserViewModel(user);

        return userViewModel;
    }
    @PostMapping("/byUsernamePassword")
    public UserViewModel byUsernamePassword(@RequestBody UserViewModel userViewModel) {
        User user = this.userRepo.findByUsernameAndPassword(userViewModel.getUsername(),userViewModel.getPassword());
         userLogin = user;
        if (user == null) {
            throw new EntityNotFoundException();
        }

        UserViewModel userViewModel1 = this.convertToUserViewModel(user);

        return userViewModel1;
    }
//    @GetMapping("/all")
//    public ResponseEntity<List<User>> getAllUsers () {
//        List<User> users = UserService.findAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<User> getUserById (@PathVariable("id") Long id) {
//        User user = UserService.findUserById(id);
//        return new ResponseEntity<>(User, HttpStatus.OK);
//    }
//
    @PostMapping("/add")
    public User create(@Valid @RequestBody UserViewModel userCreateViewModel) {

        User userEntity = this.convertToUserEntity(userCreateViewModel);
        userLogin = userEntity;



        // save user instance to petmanager.repo
        this.userRepo.save(userEntity);
        Role defaultRole = roleRepo.findByDescription("Πολίτης");
        UserRole userRole = new UserRole(userEntity, defaultRole);
        this.userRoleRepo.save(userRole);
        this.byUsernamePassword(this.convertToUserViewModel(userEntity));
        return userEntity;
    }
    @GetMapping("/RoleByUserId/{id}")
    public Set<RoleViewModel> RoleByUserId(@PathVariable String id) {
        List<Role> roles = this.userRoleRepo.findByUserId(id);
Set<RoleViewModel> roleViewModels = new HashSet<>();
        for (Role role : roles) {
            RoleViewModel roleViewModel = new RoleViewModel();
            roleViewModel.setId(role.getId());
            roleViewModel.setDescription(role.getDescription());
            roleViewModel.setName(role.getName().getLabel());
            roleViewModels.add(roleViewModel);
        }
//        UserViewModel userViewModel = this.convertToUserViewModel(user);

        return roleViewModels;
    }
//
//    @PutMapping("/update")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        User updateUser = UserService.updateUser(User);
//        return new ResponseEntity<>(updateUser, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
//        UserService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

private User convertToUserEntity(UserViewModel viewModel) {

    //   Role role = this.roleRepository.findById(viewModel.getRoleid()).get();
    User entity = new User(viewModel.getName(),viewModel.getUsername(),viewModel.getEmail(),viewModel.getPassword(), viewModel.getPhone(), viewModel.getCity());

    return entity;
}
}
