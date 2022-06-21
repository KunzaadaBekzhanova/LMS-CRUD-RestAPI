package peaksoft.restapi.dto.course;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CourseRequest {
    private Long id;
    private String courseName;
    private String duration;
}
