package com.example.caravan.service;

import com.example.caravan.dto.TaskCustomDTO;
import com.example.caravan.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO create(TaskCustomDTO taskDTO);
    List<TaskDTO> getByTitle(String title);
}
