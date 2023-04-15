package org.example.spring.service;

import lombok.RequiredArgsConstructor;
import org.example.spring.database.entity.Company;
import org.example.spring.database.repository.CRUDRepository;
import org.example.spring.dto.CompanyReadDTO;
import org.example.spring.listener.entity.AccessType;
import org.example.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final ApplicationEventPublisher applicationEventPublisher;

    private final CRUDRepository<Company, Integer> companyRepository;
    private final UserService userService;

    public Optional<CompanyReadDTO> findById(Integer id) {
        return companyRepository.findByID(id).map(company -> {
            applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
            return new CompanyReadDTO(company.getId());
        });
    }
}
