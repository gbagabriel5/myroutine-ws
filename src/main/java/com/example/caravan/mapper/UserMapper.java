package com.example.caravan.mapper;

import com.example.caravan.domain.User;
import com.example.caravan.dto.UserDTO;

public class UserMapper {
    public UserDTO convertToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        entity.getTasks().forEach(tasks -> dto.getTasks().add(new TaskMapper().convertToDTO(tasks)));
        return dto;
    }

    public User convertToEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        dto.getTasks().forEach(tasksDTOs -> entity.getTasks().add(new TaskMapper().convertToEntity(tasksDTOs)));
        return entity;
    }

    public User convertToUpdate(User user, User userReturn) {
        user.setId(userReturn.getId());
        if(user.getName() == null)
            user.setName(userReturn.getName());
        if(user.getEmail() == null)
            user.setEmail(userReturn.getEmail());
        if(user.getPassword() == null)
            user.setPassword(userReturn.getPassword());
        userReturn.getTasks().forEach(tasks -> user.getTasks().add(tasks));
        return user;
    }
}
