package tech.getarrays.petmanager.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.petmanager.exception.ResourceNotFoundException;
import tech.getarrays.petmanager.model.Pet;
import tech.getarrays.petmanager.model.Role;
import tech.getarrays.petmanager.repo.RoleRepo;
import tech.getarrays.petmanager.service.PetService;
import tech.getarrays.petmanager.viewModel.RoleViewModel;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleResource {
   @Autowired
    private RoleRepo roleRepo;

   public RoleResource(RoleRepo roleRepo) {
       this.roleRepo = roleRepo;
   }
   // get all Roles
    @GetMapping("/all")
    public List<Role> all() {
       return this.roleRepo.findAll();
    }
    @GetMapping("/byId/{id}")
    public ResponseEntity<RoleViewModel> getbyId(@PathVariable(value = "id") String id) throws ResourceNotFoundException {


        //   var user = this.roleRepository.findById(id).orElse(null);

        Role role = this.roleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found for this id :: " + id));
        if (role == null) {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().body(this.convertToRoleViewModel(role));
    }
    protected RoleViewModel convertToRoleViewModel(Role entity) {
        RoleViewModel viewModel = new RoleViewModel();
        viewModel.setId(entity.getId());
        viewModel.setName(entity.getName().getLabel());
        viewModel.setDescription(entity.getDescription());
        //      viewModel.setNbUsers(entity.getUsers().size());

        return viewModel;
    }
}
