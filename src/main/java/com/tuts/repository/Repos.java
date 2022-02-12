package com.tuts.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tuts.model.student;

@Repository
public interface Repos extends CrudRepository<student, String> {
    Page<student> findAll(Pageable pageable);
    Page<student> findByTitleContainingIgnoreCase(String domainID, Pageable pageable);

}
