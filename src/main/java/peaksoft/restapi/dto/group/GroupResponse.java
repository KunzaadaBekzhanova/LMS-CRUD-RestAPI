package peaksoft.restapi.dto.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.entities.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupResponse {
    private Long id;
    private String groupName;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;

    @JsonIgnore
    private String courseName;
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @JsonIgnore
    private List<Student> students = new ArrayList<>();
    @JsonIgnore
    private Company company;
}
