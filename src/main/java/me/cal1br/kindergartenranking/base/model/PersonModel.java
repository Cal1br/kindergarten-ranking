package me.cal1br.kindergartenranking.base.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PersonModel {
    private long id;
    private String name;
    private LocalDateTime dateOfBirth;
}
