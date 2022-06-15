package peaksoft.restapi.mappers;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.StudentResponse;
import peaksoft.restapi.entities.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {
    public StudentResponse viewStudent(Student student){
        if(student == null){
            return null;
        }
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setEmail(student.getEmail());
        response.setSurname(student.getSurname());
        response.setAge(student.getAge());
        response.setActive(student.isActive());
        response.setCreated(student.getCreated());

        return response;
    }
    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> responses = new ArrayList<>();
        for( Student student: students){
            responses.add(viewStudent(student));
        }
        return responses;
    }
}
