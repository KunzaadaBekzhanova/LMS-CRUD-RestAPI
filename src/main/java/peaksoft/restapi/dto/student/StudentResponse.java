package peaksoft.restapi.dto.student;

import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.StudyFormat;
import peaksoft.restapi.entities.Group;


import java.time.LocalDate;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;

    private Group groups;

}
