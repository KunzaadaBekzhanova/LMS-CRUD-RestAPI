package peaksoft.restapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.StudentRequest;
import peaksoft.restapi.dto.StudentResponse;
import peaksoft.restapi.services.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
public class StudentController {

    private final StudentService service;

    @PostMapping
    public StudentResponse create(@RequestBody StudentRequest request){
        return  service.create(request);
    }
    @PutMapping("{id}")
    public StudentResponse update(@PathVariable long id, @RequestBody StudentRequest request){
        return service.update(id,request);
    }
    @PutMapping("{id}")
    public StudentResponse findById(@PathVariable long id){
        return service.findById(id);
    }
    @GetMapping("{id}")
    public StudentResponse delete(@PathVariable long id){
        return service.deleteById(id);
    }
    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return service.getAllStudents();
    }
}
