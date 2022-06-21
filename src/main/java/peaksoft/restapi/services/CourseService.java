package peaksoft.restapi.services;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.dto.course.CourseResponse;
import peaksoft.restapi.dto.course.CourseResponseView;
import peaksoft.restapi.entities.Course;
import peaksoft.restapi.mappers.course.CourseEditMapper;
import peaksoft.restapi.mappers.course.CourseViewMapper;
import peaksoft.restapi.repositories.CourseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private  final CourseRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;

    public CourseResponse create(CourseRequest courseRequest){
        Course course = editMapper.create(courseRequest);
        repository.save(course);
        return viewMapper.viewCourse(course);
    }
    public CourseResponse update(Long id,CourseRequest courseRequest){
        Course course = repository.findById(id).get();
        editMapper.update(course,courseRequest);
        return viewMapper.viewCourse(repository.save(course));
    }
    public CourseResponse findById(Long id){
        Course course = repository.findById(id).get();
        return viewMapper.viewCourse(course);
    }
    public CourseResponse delete(Long id){
        Course course = repository.getById(id);
        repository.delete(course);
        return viewMapper.viewCourse(course);
    }
    public List<CourseResponse> getAllCourses(){
        return viewMapper.view(repository.findAll());
    }

    public CourseResponse deleteById(Long id) {
        Course course = repository.getById(id);
        repository.delete(course);
        return viewMapper.viewCourse(course);
    }

    public  List<CourseResponse> view(List<Course> courses){
        List<CourseResponse> responses = new ArrayList<>();
        for(Course course: courses){
            responses.add(viewMapper.viewCourse(course));
        }
        return responses;
    }

}
