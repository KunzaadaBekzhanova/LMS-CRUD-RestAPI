package peaksoft.restapi.mappers.teacher;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.teacher.TeacherResponse;
import peaksoft.restapi.entities.Teacher;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherViewMapper {
    public TeacherResponse viewTeacher(Teacher teacher){
        if(teacher == null){
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setId(teacher.getId());
        teacherResponse.setFirstName(teacher.getFirstName());
        teacherResponse.setLastName(teacher.getLastName());
        teacherResponse.setEmail(teacher.getEmail());

        return teacherResponse;
    }
    public List<TeacherResponse> view(List<Teacher> teachers){
        List<TeacherResponse> responses = new ArrayList<>();
        for (Teacher teacher: teachers){
            responses.add(viewTeacher(teacher));
        }
        return responses;
    }
}
