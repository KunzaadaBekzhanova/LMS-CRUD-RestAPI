package peaksoft.restapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.student.StudentRequest;
import peaksoft.restapi.dto.student.StudentResponse;
import peaksoft.restapi.dto.student.StudentResponseView;
import peaksoft.restapi.services.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
@Tag(name = "Student API", description = "User with role admin can add, update, delete or get all students")
public class StudentController {

    private final StudentService service;

    @PostMapping
    @Operation(summary = "can create student", description = "we can create student")
    public StudentResponse create(@RequestBody StudentRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "can update student", description = "we can update student by id")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/find/{id}")
    @Operation(summary = "can find student", description = "we can find student by ID")
    public StudentResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    @Operation(summary = "can delete student", description = "we can delete student by ID")
    public StudentResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents(){
        return service.getAllStudents();
    }


}
