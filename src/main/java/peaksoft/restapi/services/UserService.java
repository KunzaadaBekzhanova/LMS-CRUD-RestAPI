package peaksoft.restapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import peaksoft.restapi.entities.Role;
import peaksoft.restapi.entities.User;
import peaksoft.restapi.repositories.RoleRepo;
import peaksoft.restapi.repositories.UserRepo;

@Component
@RequiredArgsConstructor
public class UserService {

    private final UserRepo repo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;

    public User saveUser(User user) {
//            Role userRole = roleRepo.findRoleName("Role_Admin");
        Role userRole = new Role();
        userRole.setRoleName("USER");
        user.setRole(userRole);
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }

    public User findByEmail(String email) {
        return repo.finByEmail(email);
//            return null;

    }

    public User findByEmailAndPassword(String email, String password) {
        User user = findByEmail(email);
        if (user != null) {
            if (encoder.matches(password, user.getPassword())) {
                return user;
            } else {
                throw new BadCredentialsException("invalid");
            }
        }
        throw new BadCredentialsException("invalid");
    }
}

