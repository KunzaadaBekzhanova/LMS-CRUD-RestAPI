package peaksoft.restapi.mappers.student;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.student.StudentRequest;
import peaksoft.restapi.entities.Group;
import peaksoft.restapi.entities.Student;


@Component
public class StudentEditMapper {
    public Student create(StudentRequest request){
        if (request == null) {
            return null;
        }
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudyFormat());
       // student.setGroups(new Group());

        return student;
    }

    public void update(Student student, StudentRequest request){
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());


    }
}
