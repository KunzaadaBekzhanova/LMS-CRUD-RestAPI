package peaksoft.restapi.dto.company;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CompanyRequest {
    private String companyName;
    private String locatedCountry;
}
