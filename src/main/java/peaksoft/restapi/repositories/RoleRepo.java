package peaksoft.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapi.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
//    Role findRoleName (String roleName);
}
