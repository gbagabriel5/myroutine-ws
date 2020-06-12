package com.example.caravan.service.impl;

import com.example.caravan.domain.User;
import com.example.caravan.dto.UserDTO;
import com.example.caravan.exception.NotFoundException;
import com.example.caravan.mapper.UserMapper;
import com.example.caravan.repository.UserRepository;
import com.example.caravan.service.UserService;
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
        user = repository.save(user);
        dto = userMapper.convertToDTO(user);
        return dto;
    }

    @Override
    public UserDTO update(UserDTO dto) {
        User user = userMapper.convertToEntity(dto);
        Optional<User> userReturn = repository.findById(user.getId());
        if (userReturn.isPresent())
            user = repository.save(userMapper.convertToUpdate(user, userReturn));
        else
            throw new NotFoundException("Usuario nao encontrado!");
        dto = userMapper.convertToDTO(user);
        return dto;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDTO> getByName(String name) {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> listByName = repository.findByName(name);
        listByName.forEach(users -> userDTOS.add(userMapper.convertToDTO(users)));
        if (name == null) {
            List<User> listAll = repository.findAll();
            listAll.forEach(users -> userDTOS.add(userMapper.convertToDTO(users)));
        }
        return userDTOS;
    }

    @Override
    public boolean validatesLogin(String email, String password) {
        Optional<User> user = repository.findByEmailAndPassword(email, password);
        if (user.isPresent())
            return true;
        return false;
    }
}
