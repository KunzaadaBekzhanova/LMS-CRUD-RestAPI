package peaksoft.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapi.entities.Group;

public interface GroupRepository extends JpaRepository<Group,Long> {

}
