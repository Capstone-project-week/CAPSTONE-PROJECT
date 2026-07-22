package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Loginrepository;
import com.example.demo.tables.Login;

@Service
public class LoginService {
@Autowired
Loginrepository Repo;
public Login register(Login login) {
    return Repo.save(login);
}

public Login getUserById(Long id) {
    return Repo.findById(id).orElse(null);
}

public Login getUserByEmail(String email) {
    return Repo.findByEmail(email).orElse(null);
}

}
