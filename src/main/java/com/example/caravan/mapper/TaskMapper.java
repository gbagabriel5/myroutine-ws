package com.example.caravan.mapper;

import com.example.caravan.domain.Task;
import com.example.caravan.dto.TaskDTO;

public class TaskMapper {
    public TaskDTO convertToDTO(Task entity) {
        TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setData(entity.getData());
        if(entity.getUser() != null)
            dto.setUserDTO(new UserMapper().convertToDTO(entity.getUser()));
        return dto;
    }

    public Task convertToEntity(TaskDTO dto) {
        Task entity = new Task();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setData(dto.getData());
        if(dto.getUserDTO() != null)
            entity.setUser(new UserMapper().convertToEntity(dto.getUserDTO()));
        return entity;
    }
}
