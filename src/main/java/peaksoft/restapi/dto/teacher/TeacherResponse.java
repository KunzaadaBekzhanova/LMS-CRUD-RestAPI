package peaksoft.restapi.dto.teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.StudyFormat;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.entities.Course;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.MERGE;

@Getter
@Setter
public class TeacherResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    @JsonIgnore
    private String courseName;
    @JsonIgnore
    private Course course;
    @JsonIgnore
    private Company company;

}
