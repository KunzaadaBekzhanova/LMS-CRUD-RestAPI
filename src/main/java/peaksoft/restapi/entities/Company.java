package peaksoft.restapi.entities;

import lombok.*;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "companies")
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;

    //@OneToMany(fetch=FetchType.EAGER ,cascade = {CascadeType.MERGE,
    //        CascadeType.REMOVE}, mappedBy = "company")

    //private List<Course> courses = new ArrayList<>();

    @OneToOne
    private Course course;

}
