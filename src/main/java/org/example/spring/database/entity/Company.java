package org.example.spring.database.entity;

public class Company {
    private Integer id;

    public Company(Integer id) {
        this.id = id;
    }

    public static Company of(Integer id) {
        return new Company(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
