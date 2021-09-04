package com.example.SampleFacebook.entity;

import com.example.SampleFacebook.common.entity.EntityBase;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_user")
public class User extends EntityBase {
    private String name;
    private LocalDate dob;
    private String gender;
    private String address;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "user")
    private Set<Post> posts = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();
}
