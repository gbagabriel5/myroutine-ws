package com.gba.myroutine.service;

import com.gba.myroutine.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO create(TaskDTO taskDTO);
    TaskDTO update(TaskDTO taskDTO);
    List<TaskDTO> getByTitle(String title);
    TaskDTO getById(Integer id);
    boolean delete(Integer id) throws Exception;
}
