package peaksoft.restapi.mappers.course;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.course.CourseRequest;
import peaksoft.restapi.entities.Course;

@Component
public class CourseEditMapper {
    public Course create(CourseRequest courseRequest){
        if (courseRequest == null) {
            return null;
        }
       Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());

        return course;
    }
    public void update(Course course, CourseRequest courseRequest){
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());

    }
}
