package com.example.SampleFacebook.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate created_date = LocalDate.now() ;

    private String created_by;

    private LocalDate modified_date = LocalDate.now() ;

    private String modified_by;
}
