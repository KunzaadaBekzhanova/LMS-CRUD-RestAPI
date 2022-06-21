package peaksoft.restapi.services;

import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.company.CompanyRequest;
import peaksoft.restapi.dto.company.CompanyResponse;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.mappers.company.CompanyEditMapper;
import peaksoft.restapi.mappers.company.CompanyViewMapper;
import peaksoft.restapi.repositories.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class CompanyService {
    private final CompanyRepository repository;
    private final CompanyEditMapper editMapper;
    private final CompanyViewMapper viewMapper;

    public CompanyService(CompanyRepository repository, CompanyEditMapper editMapper, CompanyViewMapper viewMapper) {
        this.repository = repository;
        this.editMapper = editMapper;
        this.viewMapper = viewMapper;
    }

    public CompanyResponse create(CompanyRequest companyRequest){
        Company company = editMapper.create(companyRequest);
        repository.save(company);
        return viewMapper.viewCompany(company);
    }
    public CompanyResponse update(Long id, CompanyRequest companyRequest){
        Company company = repository.findById(id).get();
        editMapper.update(company, companyRequest);
        return viewMapper.viewCompany(repository.save(company));
    }
    public CompanyResponse findById(Long id){
        Company company = repository.findById(id).get();
        return viewMapper.viewCompany(company);
    }
    public CompanyResponse delete(Long id){
        Company company = repository.getById(id);
        repository.delete(company);
        return viewMapper.viewCompany(company);
    }
    public List<CompanyResponse> getAllStudents(){
        return viewMapper.view(repository.findAll());
    }

    public CompanyResponse deleteById(Long id) {
        Company company = repository.getById(id);
        repository.delete(company);
        return viewMapper.viewCompany(company);
    }

    public List<CompanyResponse> view(List<Company> companies){
        List<CompanyResponse> responses = new ArrayList<>();
        for(Company company: companies){
            responses.add(viewMapper.viewCompany(company));
        }
        return responses;
    }


    public List<CompanyResponse> getAllCompanies() {
        return viewMapper.view(repository.findAll());
    }
}
