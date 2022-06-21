package peaksoft.restapi.mappers.group;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.group.GroupResponse;
import peaksoft.restapi.entities.Group;

import java.util.ArrayList;
import java.util.List;

@Component
public class GroupViewMapper {
    public GroupResponse viewGroup(Group group){
        if(group == null){
            return null;
        }
        GroupResponse groupResponse = new GroupResponse();
        groupResponse.setId(group.getId());
        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setDateOfStart(group.getDateOfStart());
        groupResponse.setDateOfFinish(group.getDateOfFinish());
        return groupResponse;
    }

    public List<GroupResponse> view(List<Group> groups){
        List<GroupResponse> responses = new ArrayList<>();
        for(Group group: groups){
            responses.add(viewGroup(group));
        }
        return responses;
    }
}
