package com.example.SampleFacebook.form;

import com.example.SampleFacebook.entity.User;
import lombok.Data;

@Data
public class AddCommentForm {
    private Long idPost;
    private Integer level;
    private String content;
    private Long idParentComment;
}
