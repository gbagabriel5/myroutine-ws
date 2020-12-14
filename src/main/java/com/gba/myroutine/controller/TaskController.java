package com.gba.myroutine.controller;

import com.gba.myroutine.dto.TaskDTO;
import com.gba.myroutine.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(value = "Task Controller")
@RestController
@RequestMapping(value = "/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ApiOperation(value = "Create Task")
    public TaskDTO create (@ApiParam(value = "Task") @RequestBody @Valid TaskDTO dto) {
        return taskService.create(dto);
    }

    @PutMapping
    @ApiOperation(value = "update Task")
    public TaskDTO update (@ApiParam(value = "Task") @RequestBody @Valid TaskDTO dto) {
        return taskService.update(dto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete Task by ID")
    public boolean delete(@PathVariable Integer id) throws Exception {
        return taskService.delete(id);
    }

    @GetMapping
    @ApiParam(value = "List by title")
    public List<TaskDTO> findByTitle(@RequestParam(value = "title", required = false) String title) {
        return taskService.getByTitle(title);
    }

    @GetMapping("/{id}")
    @ApiParam(value = "Get Task by Id")
    public TaskDTO findById(@PathVariable(value = "id") Integer id) {
        return taskService.getById(id);
    }
}
