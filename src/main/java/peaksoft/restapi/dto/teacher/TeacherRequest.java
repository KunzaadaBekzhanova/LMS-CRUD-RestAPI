package peaksoft.restapi.dto.teacher;

import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.StudyFormat;

@Getter
@Setter
public class TeacherRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
