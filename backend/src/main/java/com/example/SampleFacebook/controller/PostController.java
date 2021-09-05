package com.example.SampleFacebook.controller;

import com.example.SampleFacebook.common.entity.ResponseBase;
import com.example.SampleFacebook.entity.Post;
import com.example.SampleFacebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(path = "/getnewpost")
    public ResponseEntity<ResponseBase> getNewPost(){
        postService.getPostHome();
        return null;
    }
}
