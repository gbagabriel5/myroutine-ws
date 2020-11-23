package com.example.caravan.service.impl;

import com.example.caravan.domain.Task;
import com.example.caravan.domain.User;
import com.example.caravan.dto.TaskDTO;
import com.example.caravan.dto.UserDTO;
import com.example.caravan.mapper.TaskMapper;
import com.example.caravan.repository.TaskRepository;
import com.example.caravan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private TaskMapper taskMapper = new TaskMapper();

    @Autowired
    private TaskRepository repository;

    @Override
    public TaskDTO create(TaskDTO taskDTO) {
        Task task = taskMapper.convertToEntity(taskDTO);
        repository.save(task);
        taskDTO = taskMapper.convertToDTO(task);
        return taskDTO;
    }

    @Override
    public List<TaskDTO> getByTitle(String title) {
        List<TaskDTO> taskDTOS = new ArrayList<>();
        if (title != null) {
            List<Task> listByName = repository.findByTitleIgnoreCaseContaining(title);
            listByName.forEach(tasks -> taskDTOS.add(taskMapper.convertToDTO(tasks)));
        } else {
            List<Task> listAll = repository.findAll();
            listAll.forEach(tasks -> taskDTOS.add(taskMapper.convertToDTO(tasks)));
        }
        return taskDTOS;
    }
}
