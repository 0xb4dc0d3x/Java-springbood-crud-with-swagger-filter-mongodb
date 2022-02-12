package com.tuts.service;

import com.tuts.model.student;
import com.tuts.repository.Repos;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@org.springframework.stereotype.Service
public class Service {

    private final Repos sRepository;

    // read operation
    public List<student> fetchSlider() {
        return (List<student>) sRepository.findAll();
    }

    public Optional<student> fetchSliderById(String id) {
        return  sRepository.findById(id);
    }

    // save operation
    public student saveSlider(student student) {
        Optional<student> stdByEmail = sRepository.findById(student.getEmail());
        if(stdByEmail.isPresent()){
            throw new IllegalStateException("this email is registered ");
        }
        return sRepository.save(student);
    }

    // update operation
    @Transactional
    public void updateSlider(student student, String email) {
        student std = sRepository.findById(email).get();

        if (Objects.nonNull(student.getEmail())) {
            std.setEmail(student.getEmail());
        }
        if (Objects.nonNull(student.getAge())) {
            std.setAge(student.getAge());
        }
        if (Objects.nonNull(student.getFirstName())) {
            std.setFirstName(student.getFirstName());
        }
        if (Objects.nonNull(student.getLastName())) {
            std.setLastName(student.getLastName());
        }
        if (Objects.nonNull(student.getAddress())) {
            std.setAddress(student.getAddress());
        }
        sRepository.save(std);
    }

    // delete operation
    public void deleteSliderById(String id) {
        boolean exist = sRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("student with " + id + " does not exist");
        }
        sRepository.deleteById(id);
    }
}
