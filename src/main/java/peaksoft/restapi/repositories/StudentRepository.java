package peaksoft.restapi.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapi.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
