package org.example.spring.service;

import org.example.spring.database.entity.Company;
import org.example.spring.database.repository.CRUDRepository;
import org.example.spring.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final CRUDRepository<Company, Integer> companyRepository;

    @Autowired
    public UserService(UserRepository userRepository,
                       CRUDRepository<Company, Integer> companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
