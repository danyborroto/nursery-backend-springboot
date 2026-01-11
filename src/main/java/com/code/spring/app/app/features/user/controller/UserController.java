package com.code.spring.app.app.features.user.controller;

import com.code.spring.app.app.features.user.dto.UserCreateDto;
import com.code.spring.app.app.features.user.dto.UserResponseDto;
import com.code.spring.app.app.features.user.dto.UserUpdateDto;
import com.code.spring.app.app.features.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public List<UserResponseDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserResponseDto getOne(@PathVariable Integer id){
        return userService.getOne(id);
    }

    @PostMapping
    public UserResponseDto create(@Valid @RequestBody UserCreateDto dto){
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable Integer id, @Valid @RequestBody UserUpdateDto dto){
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return userService.delete(id);
    }
}
