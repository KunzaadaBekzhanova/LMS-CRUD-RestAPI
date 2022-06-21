package peaksoft.restapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.teacher.TeacherRequest;
import peaksoft.restapi.dto.teacher.TeacherResponse;
import peaksoft.restapi.services.TeacherService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/teacher")
public class TeacherController {
    private final TeacherService service;

    @PostMapping

    public TeacherResponse create(@RequestBody TeacherRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public TeacherResponse update(@PathVariable Long id, @RequestBody TeacherRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/find/{id}")
    public TeacherResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public TeacherResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<TeacherResponse> getAllTeachers(){
        return service.getAllTeachers();
    }


}
