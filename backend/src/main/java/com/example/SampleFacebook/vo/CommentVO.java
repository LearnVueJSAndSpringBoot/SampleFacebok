package com.example.SampleFacebook.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class CommentVO {
    private Long id;
    private String content;
    private LocalDate timeComment;
    private String user;
    private Integer level;
    private List<CommentVO> commentVOS = new ArrayList<>();
}
