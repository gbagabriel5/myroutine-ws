package com.example.caravan.mapper;

import com.example.caravan.domain.User;
import com.example.caravan.dto.UserDTO;
import java.util.Optional;

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
        return entity;
    }

    public User convertToUpdate(User user, Optional<User> userReturn) {
        user.setId(userReturn.get().getId());
        if(user.getName() == null)
            user.setName(userReturn.get().getName());
        if(user.getCpf() == null)
            user.setCpf(userReturn.get().getCpf());
        if(user.getEmail() == null)
            user.setEmail(userReturn.get().getEmail());
        if(user.getPassword() == null)
            user.setPassword(userReturn.get().getPassword());
        if(user.getAddress() == null)
            user.setAddress(userReturn.get().getAddress());
        if(user.getCity() == null)
            user.setCity(userReturn.get().getCity());
        if(user.getState() == null)
            user.setState(userReturn.get().getState());
        if(user.getZipCode() == null)
            user.setZipCode(userReturn.get().getZipCode());
        return user;
    }
}
