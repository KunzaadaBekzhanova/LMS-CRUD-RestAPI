package peaksoft.restapi.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.group.GroupRequest;
import peaksoft.restapi.dto.group.GroupResponse;
import peaksoft.restapi.dto.group.GroupResponseView;
import peaksoft.restapi.entities.Group;
import peaksoft.restapi.mappers.group.GroupEditMapper;
import peaksoft.restapi.mappers.group.GroupViewMapper;
import peaksoft.restapi.repositories.GroupRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository repository;
    private final GroupEditMapper editMapper;
    private final GroupViewMapper viewMapper;

    public GroupResponse create(GroupRequest groupRequest){
        Group group = editMapper.create(groupRequest);
        repository.save(group);
        return viewMapper.viewGroup(group);
    }
    public GroupResponse update(Long id,GroupRequest groupRequest){
        Group student = repository.findById(id).get();
        editMapper.update(student,groupRequest);
        return viewMapper.viewGroup(repository.save(student));
    }
    public GroupResponse findById(Long id){
        Group group = repository.findById(id).get();
        return viewMapper.viewGroup(group);
    }
    public GroupResponse delete(Long id){
        Group group = repository.getById(id);
        repository.delete(group);
        return viewMapper.viewGroup(group);
    }
    public List<GroupResponse> getAllGroups(){
        return viewMapper.view(repository.findAll());
    }

    public GroupResponse deleteById(Long id) {
        Group group = repository.getById(id);
        repository.delete(group);
        return viewMapper.viewGroup(group);
    }

    public  List<GroupResponse> view(List<Group> groups){
        List<GroupResponse> responses = new ArrayList<>();
        for(Group group: groups){
            responses.add(viewMapper.viewGroup(group));
        }
        return responses;
    }

}
