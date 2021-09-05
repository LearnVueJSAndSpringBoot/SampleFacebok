package com.example.SampleFacebook.controller;

import com.example.SampleFacebook.common.entity.ResponseBase;
import com.example.SampleFacebook.form.AddCommentForm;
import com.example.SampleFacebook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping(path = "/insertcomment")
    public ResponseEntity<ResponseBase> addNewPost(@RequestBody AddCommentForm addCommentForm){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setData(commentService.insertComment(addCommentForm));
        responseBase.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(responseBase,HttpStatus.OK);
    }
}
