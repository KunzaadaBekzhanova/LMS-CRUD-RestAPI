package peaksoft.restapi.dto.group;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupResponseView {
    List<GroupResponse> responses;
}
