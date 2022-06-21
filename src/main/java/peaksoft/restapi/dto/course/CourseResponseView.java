package peaksoft.restapi.dto.course;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseResponseView {
    List<CourseResponse> responses;
}
