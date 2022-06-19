package peaksoft.restapi.dto.student;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import peaksoft.restapi.StudyFormat;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
public class StudentRequest {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private StudyFormat studyFormat;
//    private LocalDate created;
//    private boolean isActive;
}
