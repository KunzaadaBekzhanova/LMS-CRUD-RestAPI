package peaksoft.restapi.mappers.teacher;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.teacher.TeacherRequest;
import peaksoft.restapi.entities.Teacher;

@Component
public class TeacherEditMapper {
    public Teacher create(TeacherRequest teacherRequest){
        if (teacherRequest == null) {
            return null;
        }
        Teacher teacher = new Teacher();
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setEmail(teacherRequest.getEmail());

        return teacher;
    }
    public void update(Teacher teacher, TeacherRequest teacherRequest){
        teacher.setFirstName(teacherRequest.getFirstName());
        teacher.setLastName(teacherRequest.getLastName());
        teacher.setEmail(teacherRequest.getEmail());

    }
}
