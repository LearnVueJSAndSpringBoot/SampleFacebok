package com.example.SampleFacebook.service.impl;

import com.example.SampleFacebook.entity.Post;
import com.example.SampleFacebook.repository.PostRepository;
import com.example.SampleFacebook.service.PostService;
import com.example.SampleFacebook.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<PostVO> getPostHome() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("datePost").descending());
        List<Post> posts = postRepository.findAll(pageable).stream().toList();
        List<PostVO> postVOS = new ArrayList<>();
        return null;
    }
}
