package com.example.SampleFacebook.service;

import com.example.SampleFacebook.form.AddPostForm;
import com.example.SampleFacebook.form.SearchForm;
import com.example.SampleFacebook.vo.PostVO;

import java.util.List;

public interface PostService {
    List<PostVO> getPostHome();
    List<PostVO> searchPost(SearchForm searchForm);

    Boolean insertPost(AddPostForm addPostForm);
}
