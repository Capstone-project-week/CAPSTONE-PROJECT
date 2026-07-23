package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.tables.Login;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Loginrepository extends JpaRepository<Login, Long> {
	Optional<Login> findByEmail(String email);
	Optional<Login> findByUsername(String username);
}
