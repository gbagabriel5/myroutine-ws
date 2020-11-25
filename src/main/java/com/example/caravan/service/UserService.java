package com.example.caravan.service;

import com.example.caravan.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO update(UserDTO dto);
    boolean delete(Integer id);
    List<UserDTO> getByName(String name);
    UserDTO getById(Integer id);
    boolean validatesLogin(String email, String password);
}
