package peaksoft.restapi.repositories;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import peaksoft.restapi.entities.Student;


import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where upper(s.name) like concat('%',:text,'%')"+
    "or upper(s.surname) like concat('%',:text,'%') or upper(s.email) like concat('%',:text,'%')")
    List<Student> searchAndPagination(@Param("text") Student text, Pageable pageable);
}
