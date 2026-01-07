package com.code.spring.app.app.features.format.repository;

import com.code.spring.app.app.features.format.entity.Format;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormatRepository extends JpaRepository<Format, Integer> {
}
