package peaksoft.restapi.dto.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.entities.Group;
import peaksoft.restapi.entities.Teacher;

import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.REMOVE;

@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String courseName;
    private String duration;
    @JsonIgnore
    private Company company;
    @JsonIgnore
    private List<Group> groups = new ArrayList<>();
    @JsonIgnore
    private Teacher teacher;
}
