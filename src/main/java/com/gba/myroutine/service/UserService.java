package com.gba.myroutine.service;

import com.gba.myroutine.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO create(UserDTO dto);
    UserDTO update(UserDTO dto);
    boolean delete(Integer id);
    List<UserDTO> getByName(String name);
    UserDTO getByEmail(String email);
    UserDTO getById(Integer id);
    boolean validatesLogin(String email, String password);
}
