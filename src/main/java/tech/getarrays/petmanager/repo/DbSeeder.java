package tech.getarrays.petmanager.repo;

import tech.getarrays.petmanager.Side.RoleName;
import tech.getarrays.petmanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


/**
 * This component will only execute (and get instantiated) if the
 * property tech.getarrays.petmanager.repo.recreate is set to true in the
 * application.properties file
 */

@Component
@ConditionalOnProperty(name = "tech.getarrays.petmanager.repo.recreate", havingValue = "true")
public class DbSeeder implements  CommandLineRunner{

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;



//------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------

    @Autowired
    private UserRoleRepo userRoleRepo;


//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^



    public DbSeeder(RoleRepo roleRepo, UserRepo userRepo) {

        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws ParseException {


        //       Set<NationalDigitalPortfolio> detailSet = new HashSet<>();
        //       detailSet.add(nationalDigitalPortfolio);
        //       nationalDigitalPortfolioCore.setPortfolioSet(detailSet);
        //       nationalDigitalPortfolioCoreRepository.save(nationalDigitalPortfolioCore);


        //  this.userRepository.deleteAll();
        //  this.roleRepository.deleteAll();

        //   User user = new User("Hello", "admin","asdsadas","123456789");


        // insert all roles
        Role defaultRole = new Role(RoleName.ROLE_USER, "Πολίτης");
        Role role_DOCTOR = new Role(RoleName.ROLE_DOCTOR, "Κτηνίατρος");
        Role role_ADMIN = new Role(RoleName.ROLE_ADMIN, "Διαχειριστής");
        Role role_EMPLOYEE = new Role(RoleName.ROLE_EMPLOYEE, "Δημοτικός υπάλληλος");
        roleRepo.save(defaultRole);
        roleRepo.save(role_DOCTOR);
        roleRepo.save(role_ADMIN);
        roleRepo.save(role_EMPLOYEE);



        //Insert a User
       User user = new User("MyName", "admin", "MyEmail@email.com", "123456789", "1234567890");
//        User user = new User();
//        user.setId(String.valueOf(UUID.randomUUID()));
//        user.setEmail("MyEmail@email.com");
//        user.setName("MyName");
//        user.setUsername("admin");
//        user.setPassword("1234567890");
//        user.setPhone("1234567890");
//        this.userRepo.save(user);
//System.out.println(String.valueOf(user.getId()));
      //  user.setId(String.valueOf(UUID.randomUUID()));
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role_DOCTOR);
        roleSet.add(defaultRole);
        roleSet.add(role_ADMIN);
         this.userRepo.save(user);
//
        for (Role role : roleSet) {

            UserRole userRole = new UserRole(user, role);
            this.userRoleRepo.save(userRole);
        }
        User user1 = new User("doctor", "doctor", "doctor@email.com", "doctor", "1234567890");
//        User user = new User();
//        user.setId(String.valueOf(UUID.randomUUID()));
//        user.setEmail("MyEmail@email.com");
//        user.setName("MyName");
//        user.setUsername("admin");
//        user.setPassword("1234567890");
//        user.setPhone("1234567890");
//        this.userRepo.save(user);
//System.out.println(String.valueOf(user.getId()));
        //  user.setId(String.valueOf(UUID.randomUUID()));
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role_DOCTOR);

        this.userRepo.save(user1);
//
        for (Role role : roleSet1) {

            UserRole userRole1 = new UserRole(user1, role);
            this.userRoleRepo.save(userRole1);
        }


        User user2 = new User("employee", "employee", "employee@email.com", "employee", "1234567890");
//        User user = new User();
//        user.setId(String.valueOf(UUID.randomUUID()));
//        user.setEmail("MyEmail@email.com");
//        user.setName("MyName");
//        user.setUsername("admin");
//        user.setPassword("1234567890");
//        user.setPhone("1234567890");
//        this.userRepo.save(user);
//System.out.println(String.valueOf(user.getId()));
        //  user.setId(String.valueOf(UUID.randomUUID()));
        Set<Role> roleSet2 = new HashSet<>();
        roleSet2.add(role_EMPLOYEE);

        this.userRepo.save(user2);
//
        for (Role role : roleSet2) {

            UserRole userRole2 = new UserRole(user2, role);
            this.userRoleRepo.save(userRole2);
        }

    } }

