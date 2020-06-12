package com.example.caravan.service;

import com.example.caravan.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO update(UserDTO dto);
    void delete(Integer id);
    List<UserDTO> getByName(String name);
    boolean validatesLogin(String email, String password);
}
