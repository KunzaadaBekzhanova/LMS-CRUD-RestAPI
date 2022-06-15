package peaksoft.restapi.dto;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
public class StudentResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int age;
    private LocalDate created;
    private boolean isActive;

}
