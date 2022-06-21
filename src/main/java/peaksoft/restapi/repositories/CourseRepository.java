package peaksoft.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.restapi.entities.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
   }
