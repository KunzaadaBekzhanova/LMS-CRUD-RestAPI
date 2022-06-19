package peaksoft.restapi.dto.student;

import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.dto.student.StudentResponse;

import java.util.List;

@Getter
@Setter
public class StudentResponseView {
    List<StudentResponse> responses;

}
