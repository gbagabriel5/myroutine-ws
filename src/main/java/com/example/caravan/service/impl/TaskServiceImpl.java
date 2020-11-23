package com.example.caravan.service.impl;

import com.example.caravan.domain.Task;
import com.example.caravan.domain.User;
import com.example.caravan.dto.TaskCustomDTO;
import com.example.caravan.dto.TaskDTO;
import com.example.caravan.dto.UserDTO;
import com.example.caravan.mapper.TaskMapper;
import com.example.caravan.mapper.UserMapper;
import com.example.caravan.repository.TaskRepository;
import com.example.caravan.repository.UserRepository;
import com.example.caravan.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserRepository userRepository;

    private TaskMapper taskMapper = new TaskMapper();

    private UserMapper userMapper = new UserMapper();

    @Override
    public TaskDTO create(TaskCustomDTO customDTO) {
        User user = userRepository.getOne(customDTO.getUserId());
        TaskDTO taskDTO = taskMapper.convertCustomToDtoToCreate(customDTO, userMapper.convertToDTO(user));
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
