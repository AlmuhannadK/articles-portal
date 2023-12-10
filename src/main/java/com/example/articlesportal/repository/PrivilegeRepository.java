package com.example.articlesportal.repository;

import com.example.articlesportal.entity.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {

    Optional<Privilege> findByName(String name);
}
