package com.example.SampleFacebook.controller;

import com.example.SampleFacebook.common.entity.ResponseBase;
import com.example.SampleFacebook.entity.Post;
import com.example.SampleFacebook.form.AddPostForm;
import com.example.SampleFacebook.form.SearchForm;
import com.example.SampleFacebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping(path = "/getnewpost")
    public ResponseEntity<ResponseBase> getNewPost(){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setData(postService.getPostHome());
        responseBase.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(responseBase,HttpStatus.OK);
    }

    @PostMapping(path = "/searchpost")
    public ResponseEntity<ResponseBase> searchNewPost(@RequestBody SearchForm searchForm){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setData(postService.searchPost(searchForm));
        responseBase.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(responseBase,HttpStatus.OK);
    }

    @PostMapping(path = "/insertpost")
    public ResponseEntity<ResponseBase> addNewPost(@RequestBody AddPostForm addPostForm){
        ResponseBase responseBase = new ResponseBase();
        responseBase.setData(postService.insertPost(addPostForm));
        responseBase.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(responseBase,HttpStatus.OK);
    }
}
