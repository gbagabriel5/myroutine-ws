package com.gba.myroutine.controller;

import com.gba.myroutine.dto.UserDTO;
import com.gba.myroutine.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Api(value = "User Controller")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(value = "Create User")
    public UserDTO create(@ApiParam(value = "User") @RequestBody @Valid UserDTO dto) {
        return userService.create(dto);
    }

    @PutMapping
    @ApiOperation(value = "Update User")
    public UserDTO update(@ApiParam(value = "User") @RequestBody @Valid UserDTO dto) {
        return userService.update(dto);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delete User by ID")
    public boolean delete(@PathVariable Integer id) {
        return userService.delete(id);
    }

    @GetMapping("getByName")
    @ApiOperation(value = "List by Name")
    public List<UserDTO> getByName(@RequestParam(value = "name", required = false) String name) {
        return userService.getByName(name);
    }

    @GetMapping("getByEmail")
    @ApiOperation(value = "List by Email")
    public UserDTO getByEmail(@RequestParam(value = "email", required = false) String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/{id}")
    @ApiParam(value = "Get User by Id")
    public UserDTO getById(@PathVariable(value = "id") Integer id) {
        return userService.getById(id);
    }

    @GetMapping(value = "validatesLogin")
    @ApiOperation(value = "Validates Email and Password")
    public boolean validatesLogin(
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password)
    {
        return userService.validatesLogin(email,password);
    }
}
