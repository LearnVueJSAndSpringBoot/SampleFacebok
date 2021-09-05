package com.example.SampleFacebook.entity;

import com.example.SampleFacebook.common.entity.EntityBase;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_post")
public class Post extends EntityBase {

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDate datePost;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();
}
