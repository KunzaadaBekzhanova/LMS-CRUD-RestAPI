package peaksoft.restapi.mappers.group;

import org.springframework.stereotype.Component;
import peaksoft.restapi.dto.group.GroupRequest;
import peaksoft.restapi.entities.Group;

@Component
public class GroupEditMapper {
    public Group create(GroupRequest groupRequest){
        if (groupRequest == null) {
            return null;
        }
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());

        return group;
    }

    public void update(Group group, GroupRequest groupRequest){
        group.setCourseName(groupRequest.getGroupName());
        group.setDateOfStart(groupRequest.getDateOfStart());
        group.setDateOfFinish(groupRequest.getDateOfFinish());

    }
}
