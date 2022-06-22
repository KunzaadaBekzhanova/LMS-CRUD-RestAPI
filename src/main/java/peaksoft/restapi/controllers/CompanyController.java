package peaksoft.restapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.company.CompanyRequest;
import peaksoft.restapi.dto.company.CompanyResponse;
import peaksoft.restapi.entities.Company;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.repositories.CompanyRepository;
import peaksoft.restapi.repositories.CourseRepository;
import peaksoft.restapi.services.CompanyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/company")
@PreAuthorize("hasAuthority('ADMIN')")
public class CompanyController {
    private final CompanyService service;

    CompanyRepository companyRepository;

    CourseRepository courseRepository;


    @PostMapping("/admin")
    public CompanyResponse create(@RequestBody CompanyRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
     public CompanyResponse update(@PathVariable Long id, @RequestBody CompanyRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/find/{id}")
    public CompanyResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
     public CompanyResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<CompanyResponse> getAllCompanies(){
        return service.getAllCompanies();
    }

    @PutMapping("/{companyId}/courses/{courseId}")
    Company setCourseToCompany(
            @PathVariable Long companyId,
            @PathVariable Long courseId
    ){
        Company company = companyRepository.findById(companyId).get();
        Course course = courseRepository.findById(courseId).get();
        company.setCourse(course);
        return companyRepository.save(company);

    }

}


