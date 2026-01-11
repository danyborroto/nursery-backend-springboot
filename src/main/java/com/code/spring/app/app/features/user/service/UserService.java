package com.code.spring.app.app.features.user.service;

import com.code.spring.app.app.exception.UserNotFoundException;
import com.code.spring.app.app.features.user.dto.UserCreateDto;
import com.code.spring.app.app.features.user.dto.UserResponseDto;
import com.code.spring.app.app.features.user.dto.UserUpdateDto;
import com.code.spring.app.app.features.user.entity.User;
import com.code.spring.app.app.features.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserResponseDto> getAll() {
        return userRepository.findAll().stream()
                .map(u -> new UserResponseDto(
                        u.getUserName(),
                        u.getUserEmail(),
                        u.getUserPhone()
                ))
                .toList();
    }

    public UserResponseDto getOne(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return mapToUserResponseDto(user);
    }

    public UserResponseDto create(UserCreateDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setUserPassword(passwordEncoder.encode(dto.getUserPassword()));
        user.setUserEmail(dto.getUserEmail());
        user.setUserPhone(dto.getUserPhone());
        user.setAdmin(dto.getAdmin());
        User saved = userRepository.save(user);
        return mapToUserResponseDto(saved);
    }

    public UserResponseDto update(Integer id, UserUpdateDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        if (dto.getUserPassword() != null && !dto.getUserPassword().isBlank()) {
            user.setUserPassword(passwordEncoder.encode(dto.getUserPassword()));
        }
        if (dto.getUserName() != null) user.setUserName(dto.getUserName());
        if (dto.getUserEmail() != null) user.setUserEmail(dto.getUserEmail());
        if (dto.getUserPhone() != null) user.setUserPhone(dto.getUserPhone());
        if (dto.getAdmin() != null) user.setAdmin(dto.getAdmin());
        User saved = userRepository.save(user);
        return mapToUserResponseDto(saved);
    }

    public String delete(Integer id) {
        return userRepository.findById(id)
                .map(u -> {
                    userRepository.delete(u);
                    return "Elemento con ID: " + id + " eliminado correctamente";
                })
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    private UserResponseDto mapToUserResponseDto(User user) {
        return new UserResponseDto(
                user.getUserName(),
                user.getUserEmail(),
                user.getUserPhone()
        );
    }
}
