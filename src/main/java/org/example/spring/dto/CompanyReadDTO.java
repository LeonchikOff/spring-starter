package org.example.spring.dto;

public class CompanyReadDTO {
    private final Integer id;

    public CompanyReadDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
