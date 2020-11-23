package com.example.caravan.controller;

import com.example.caravan.dto.TaskCustomDTO;
import com.example.caravan.dto.TaskDTO;
import com.example.caravan.service.TaskService;
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

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ApiOperation(value = "Create Task")
    public TaskDTO create (@ApiParam(value = "Task") @RequestBody @Valid TaskCustomDTO dto) {
        return taskService.create(dto);
    }

    @GetMapping
    @ApiParam(value = "List by title")
    public List<TaskDTO> findByTitle(@RequestParam(value = "title", required = false) String title) {
        return taskService.getByTitle(title);
    }
}
