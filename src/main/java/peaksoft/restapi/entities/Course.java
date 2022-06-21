package peaksoft.restapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.REMOVE;

@Entity
@Getter
@Setter
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )

    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private String duration;

    @JsonIgnore
    @ManyToOne
    private Company company;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "courses", cascade = {CascadeType.MERGE, CascadeType.REMOVE} )
    private List<Group> groups;

    @OneToOne(mappedBy = "course", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private Teacher teacher;

    public Course() {
    }

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public Course(Company company) {
        this.company = company;
    }

    public Course(List<Group> groups) {
        this.groups = groups;
    }

    public Course(Teacher teacher) {
        this.teacher = teacher;
    }

}
