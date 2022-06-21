package peaksoft.restapi.mappers.company;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.company.CompanyRequest;
import peaksoft.restapi.entities.Company;

import java.util.ArrayList;

@Component
public class CompanyEditMapper {
    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        company.setCourse(company.getCourse());

        return company;

    }
    public void update(Company company, CompanyRequest companyRequest){
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
