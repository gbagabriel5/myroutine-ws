package com.example.caravan.service;

import com.example.caravan.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO create(TaskDTO taskDTO);
    TaskDTO update(TaskDTO taskDTO);
    List<TaskDTO> getByTitle(String title);
    TaskDTO getById(Integer id);
    boolean delete(Integer id) throws Exception;
}
