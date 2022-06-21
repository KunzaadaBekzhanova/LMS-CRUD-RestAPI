package peaksoft.restapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.company.CompanyResponse;
import peaksoft.restapi.dto.teacher.TeacherRequest;
import peaksoft.restapi.dto.teacher.TeacherResponse;
import peaksoft.restapi.dto.teacher.TeacherResponseView;
import peaksoft.restapi.entities.Teacher;
import peaksoft.restapi.mappers.teacher.TeacherEditMapper;
import peaksoft.restapi.mappers.teacher.TeacherViewMapper;
import peaksoft.restapi.repositories.TeacherRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository repository;
    private final TeacherEditMapper editMapper;
    private final TeacherViewMapper viewMapper;

    public TeacherResponse create(TeacherRequest teacherRequest){
        Teacher teacher = editMapper.create(teacherRequest);
        repository.save(teacher);
        return viewMapper.viewTeacher(teacher);
    }
    public TeacherResponse update(Long id,TeacherRequest teacherRequest){
        Teacher teacher = repository.findById(id).get();
        editMapper.update(teacher,teacherRequest);
        return viewMapper.viewTeacher(repository.save(teacher));
    }
    public TeacherResponse findById(Long id){
        Teacher teacher = repository.findById(id).get();
        return viewMapper.viewTeacher(teacher);
    }
    public TeacherResponse delete(Long id){
        Teacher teacher = repository.getById(id);
        repository.delete(teacher);
        return viewMapper.viewTeacher(teacher);
    }
    public List<TeacherResponse> getAllTeachers(){
        return viewMapper.view(repository.findAll());
    }

    public TeacherResponse deleteById(Long id) {
        Teacher teacher = repository.getById(id);
        repository.delete(teacher);
        return viewMapper.viewTeacher(teacher);
    }

    public  List<TeacherResponse> view(List<Teacher> teachers){
        List<TeacherResponse> responses = new ArrayList<>();
        for(Teacher teacher: teachers){
            responses.add(viewMapper.viewTeacher(teacher));
        }
        return responses;
    }


}
