package com.example.caravan.service;

import com.example.caravan.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO create(TaskDTO taskDTO);
    List<TaskDTO> getByTitle(String title);
}
