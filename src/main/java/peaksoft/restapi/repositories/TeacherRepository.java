package peaksoft.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapi.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
