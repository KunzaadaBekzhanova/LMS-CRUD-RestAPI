package peaksoft.restapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.dto.course.CourseResponseView;
import peaksoft.restapi.services.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/course")
public class CourseController {
    private final CourseService service;

    @PostMapping

    public CourseResponse create(@RequestBody CourseRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/find/{id}")
    public CourseResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public CourseResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<CourseResponse> getAllCourses(){
        return service.getAllCourses();
    }


}
