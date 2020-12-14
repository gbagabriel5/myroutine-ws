package com.gba.myroutine.service.impl;

import com.gba.myroutine.domain.User;
import com.gba.myroutine.dto.UserDTO;
import com.gba.myroutine.exception.NotFoundException;
import com.gba.myroutine.mapper.UserMapper;
import com.gba.myroutine.repository.UserRepository;
import com.gba.myroutine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;
    private UserMapper userMapper = new UserMapper();

    @Override
    public UserDTO create(UserDTO dto) {
        User user = userMapper.convertToEntity(dto);
        User userSaved = repository.save(user);
        dto = userMapper.convertToDTO(userSaved);
        return dto;
    }

    @Override
    public UserDTO update(UserDTO dto) {
        User user = userMapper.convertToEntity(dto);
        Optional<User> userReturn = repository.findById(user.getId());
        if (userReturn.isPresent())
            user = repository.save(userMapper.convertToUpdate(user, userReturn.get()));
        else
            throw new NotFoundException("Usuario nao encontrado!");
        dto = userMapper.convertToDTO(user);
        return dto;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<UserDTO> getByName(String name) {
        List<UserDTO> userDTOS = new ArrayList<>();
        if (name != null) {
            List<User> listByName = repository.findByNameIgnoreCaseContaining(name);
            listByName.forEach(users -> userDTOS.add(userMapper.convertToDTO(users)));
        } else {
            List<User> listAll = repository.findAll();
            listAll.forEach(users -> userDTOS.add(userMapper.convertToDTO(users)));
        }
        return userDTOS;
    }

    @Override
    public UserDTO getByEmail(String email) {
        UserDTO userDTO = new UserDTO();
        if (email != null) {
            Optional<User> user = repository.findByEmail(email);
            if(user.isPresent())
                userDTO = userMapper.convertToDTO(user.get());
            else
                throw new NotFoundException("Email nao encontrado!");
        }
        return userDTO;
    }

    @Override
    public UserDTO getById(Integer id) {
        Optional<User> user = repository.findById(id);
        UserDTO dto;
        if(user.isPresent())
            dto = userMapper.convertToDTO(user.get());
        else
            throw new NotFoundException("Usuario nao encontrado!");
        return dto;
    }

    @Override
    public boolean validatesLogin(String email, String password) {
        Optional<User> user = repository.findByEmailAndPassword(email, password);
        return user.isPresent();
    }
}
