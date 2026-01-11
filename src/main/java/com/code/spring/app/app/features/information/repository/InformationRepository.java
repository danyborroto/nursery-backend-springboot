package com.code.spring.app.app.features.information.repository;

import com.code.spring.app.app.features.information.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<Information,Integer> {
}
