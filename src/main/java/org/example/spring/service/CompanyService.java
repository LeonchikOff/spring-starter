package org.example.spring.service;

import org.example.spring.database.entity.Company;
import org.example.spring.database.repository.CRUDRepository;
import org.example.spring.dto.CompanyReadDTO;
import org.example.spring.listener.entity.AccessType;
import org.example.spring.listener.entity.EntityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {
    private final ApplicationEventPublisher applicationEventPublisher;

    private final CRUDRepository<Company, Integer> companyRepository;
    private final UserService userService;

    @Autowired
    public CompanyService(ApplicationEventPublisher applicationEventPublisher,
                          CRUDRepository<Company, Integer> companyRepository,
                          UserService userService) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.companyRepository = companyRepository;
        this.userService = userService;
    }

    public Optional<CompanyReadDTO> findById(Integer id) {
        return companyRepository.findByID(id).map(company -> {
            applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
            return new CompanyReadDTO(company.getId());
        });
    }
}
