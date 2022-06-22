package peaksoft.restapi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.group.GroupRequest;
import peaksoft.restapi.dto.group.GroupResponse;
import peaksoft.restapi.dto.group.GroupResponseView;
import peaksoft.restapi.services.GroupService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/group")
@PreAuthorize(value = "hasAnyAuthority('ADMIN','USER')")

public class GroupController {
    private final GroupService service;

    @PostMapping

    public GroupResponse create(@RequestBody GroupRequest request) {
        return service.create(request);
    }

    @PutMapping("/update/{id}")
    public GroupResponse update(@PathVariable Long id, @RequestBody GroupRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/find/{id}")
    public GroupResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/delete/{id}")
    public GroupResponse delete(@PathVariable Long id) {
        return service.deleteById(id);
    }

    @GetMapping
    public List<GroupResponse> getAllGroups(){
        return service.getAllGroups();
    }


}

