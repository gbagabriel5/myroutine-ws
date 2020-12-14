package com.gba.myroutine.service.impl;

import com.gba.myroutine.domain.Task;
import com.gba.myroutine.dto.TaskDTO;
import com.gba.myroutine.exception.NotFoundException;
import com.gba.myroutine.mapper.TaskMapper;
import com.gba.myroutine.repository.TaskRepository;
import com.gba.myroutine.repository.UserRepository;
import com.gba.myroutine.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Autowired
    private UserRepository userRepository;

    private TaskMapper taskMapper = new TaskMapper();

    @Override
    public TaskDTO create(TaskDTO dto) {
        Task task = taskMapper.convertToEntity(dto);
        repository.save(task);
        dto = taskMapper.convertToDTO(task);
        return dto;
    }

    @Override
    public TaskDTO update(TaskDTO dto) {
        Task task = taskMapper.convertToEntity(dto);
        Optional<Task> taskReturn = repository.findById(task.getId());
        if (taskReturn.isPresent())
            task = repository.save(taskMapper.convertToUpdate(task, taskReturn.get()));
        else
            throw new NotFoundException("Tarefa nao encontrada!");
        dto = taskMapper.convertToDTO(task);
        return dto;
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

    @Override
    public TaskDTO getById(Integer id) {
        Optional<Task> task = repository.findById(id);
        TaskDTO dto;
        if(task.isPresent())
            dto = taskMapper.convertToDTO(task.get());
        else
            throw new NotFoundException("Usuario nao encontrado!");
        return dto;
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e){
            throw new Exception(e);
        }
    }
}
