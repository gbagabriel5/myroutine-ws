package com.example.caravan.mapper;

import com.example.caravan.domain.Task;
import com.example.caravan.dto.TaskCustomDTO;
import com.example.caravan.dto.TaskDTO;
import com.example.caravan.dto.UserDTO;

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
        entity.setUser(new UserMapper().convertToEntity(dto.getUserDTO()));
        return entity;
    }

    public TaskDTO convertCustomToDtoToCreate(TaskCustomDTO customDTO, UserDTO userDto) {
        TaskDTO dto = new TaskDTO();
        dto.setId(customDTO.getId());
        dto.setTitle(customDTO.getTitle());
        dto.setDescription(customDTO.getDescription());
        dto.setData(customDTO.getData());
        dto.setUserDTO(userDto);
        return dto;
    }
}
