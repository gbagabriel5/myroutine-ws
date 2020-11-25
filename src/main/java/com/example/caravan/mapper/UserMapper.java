package com.example.caravan.mapper;

import com.example.caravan.domain.User;
import com.example.caravan.dto.UserDTO;

public class UserMapper {
    public UserDTO convertToDTO(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipCode(entity.getZipCode());
        entity.getTasks().forEach(tasks -> dto.getTasks().add(new TaskMapper().convertToDTO(tasks)));
        return dto;
    }

    public User convertToEntity(UserDTO dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZipCode(dto.getZipCode());
        dto.getTasks().forEach(tasksDTOs -> entity.getTasks().add(new TaskMapper().convertToEntity(tasksDTOs)));
        return entity;
    }

    public User convertToUpdate(User user, User userReturn) {
        user.setId(userReturn.getId());
        if(user.getName() == null)
            user.setName(userReturn.getName());
        if(user.getCpf() == null)
            user.setCpf(userReturn.getCpf());
        if(user.getEmail() == null)
            user.setEmail(userReturn.getEmail());
        if(user.getPassword() == null)
            user.setPassword(userReturn.getPassword());
        if(user.getAddress() == null)
            user.setAddress(userReturn.getAddress());
        if(user.getCity() == null)
            user.setCity(userReturn.getCity());
        if(user.getState() == null)
            user.setState(userReturn.getState());
        if(user.getZipCode() == null)
            user.setZipCode(userReturn.getZipCode());
        userReturn.getTasks().forEach(tasks -> user.getTasks().add(tasks));
        return user;
    }
}
