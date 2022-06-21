package peaksoft.restapi.dto.company;

import lombok.Getter;
import lombok.Setter;
import peaksoft.restapi.entities.Course;

import java.util.List;

@Getter
@Setter
public class CompanyResponse {
    private Long id;
    private String companyName;
    private String locatedCountry;
    private Course course;
}
