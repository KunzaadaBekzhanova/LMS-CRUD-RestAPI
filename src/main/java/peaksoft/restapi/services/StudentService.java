package peaksoft.restapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.student.StudentRequest;
import peaksoft.restapi.dto.student.StudentResponse;
import peaksoft.restapi.entities.Student;
import peaksoft.restapi.mappers.student.StudentEditMapper;
import peaksoft.restapi.mappers.student.StudentViewMapper;
import peaksoft.restapi.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;
    private final StudentEditMapper editMapper;
    private final StudentViewMapper viewMapper;

    public StudentResponse create(StudentRequest studentRequest){
        Student student = editMapper.create(studentRequest);
        repository.save(student);
        return viewMapper.viewStudent(student);
    }
    public StudentResponse update(Long id,StudentRequest studentRequest){
        Student student = repository.findById(id).get();
        editMapper.update(student,studentRequest);
        return viewMapper.viewStudent(repository.save(student));
    }
    public StudentResponse findById(Long id){
        Student student = repository.findById(id).get();
        return viewMapper.viewStudent(student);
    }
    public StudentResponse delete(Long id){
        Student student = repository.getById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }
    public List<StudentResponse> getAllStudents(){
        return viewMapper.view(repository.findAll());
    }

    public StudentResponse deleteById(Long id) {
        Student student = repository.getById(id);
        repository.delete(student);
        return viewMapper.viewStudent(student);
    }

    public  List<StudentResponse> view(List<Student> students){
        List<StudentResponse> responses = new ArrayList<>();
        for(Student student: students){
            responses.add(viewMapper.viewStudent(student));
        }
        return responses;
     }

}
