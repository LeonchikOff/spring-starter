package org.example.spring.database.repository;

import org.example.spring.bpp.annotation.Auditing;

import java.util.Optional;

public interface CRUDRepository<E, I> {
    Optional<E> findByID(I id);
    void delete(E entity);
}
