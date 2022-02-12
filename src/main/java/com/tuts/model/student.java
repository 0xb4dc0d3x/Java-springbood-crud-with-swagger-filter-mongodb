package com.tuts.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.tuts.model.address;
import com.tuts.model.gender;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private gender gender;
    private address address;
    private List<String> hobbies;
    private BigDecimal spentTimeOnReadingBook;
    private LocalDateTime created;
    private Integer age;

    public student(String firstName,
                   String lastName,
                   String email,
                   gender gender,
                   address address,
                   List<String> hobbies,
                   BigDecimal spentTimeOnReadingBook,
                   LocalDateTime created,
                   Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.hobbies = hobbies;
        this.spentTimeOnReadingBook = spentTimeOnReadingBook;
        this.created = created;
        this.age = age;
    }
}
