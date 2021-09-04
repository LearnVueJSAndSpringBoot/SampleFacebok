package com.example.SampleFacebook.entity;

import com.example.SampleFacebook.common.entity.EntityBase;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tb_comment")
public class Comment extends EntityBase {
    @Column(columnDefinition = "TEXT")
    private String content;
    private Integer level;
    private Long idParent;
    private LocalDate dateComment;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;
}
