package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.Loginrepository;
import com.example.demo.tables.Login;

@Service
public class LoginService {
@Autowired
Loginrepository repo;

public Login register(Login login) {
    return repo.save(login);
}

public Login getUserById(Long id) {
    return repo.findById(id).orElse(null);
}

public Login getUserByEmail(String email) {
    return repo.findByEmail(email).orElse(null);
}

}
