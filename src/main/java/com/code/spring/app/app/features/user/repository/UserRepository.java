package com.code.spring.app.app.features.user.repository;

import com.code.spring.app.app.features.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
