package com.example.SampleFacebook.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostVO {
    private Long id;
    private String user;
    private LocalDate timePost;
    private String contentPost;
    private List<CommentVO> commentVOS = new ArrayList<>();
}
