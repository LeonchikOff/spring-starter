package org.example.spring.database.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Company {
    private Integer id;

    public static Company of(Integer id) {
        return new Company(id);
    }
}
