package com.example.SampleFacebook.service.impl;

import com.example.SampleFacebook.entity.Comment;
import com.example.SampleFacebook.entity.Post;
import com.example.SampleFacebook.entity.User;
import com.example.SampleFacebook.form.AddPostForm;
import com.example.SampleFacebook.form.SearchForm;
import com.example.SampleFacebook.repository.PostRepository;
import com.example.SampleFacebook.service.PostService;
import com.example.SampleFacebook.vo.CommentVO;
import com.example.SampleFacebook.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Override
    public List<PostVO> getPostHome() {
        Pageable pageable = PageRequest.of(0,10, Sort.by("datePost").descending());
        List<Post> posts = postRepository.findAll(pageable).stream().toList();
        List<PostVO> postVOS = new ArrayList<>();
        for(Post post : posts){
            PostVO postVO = new PostVO();
            postVO.setId(post.getId());
            postVO.setUser(post.getUser().getName());
            postVO.setTimePost(post.getDatePost());
            postVO.setContentPost(post.getContent());
            postVO.setCommentVOS(getComment(post.getComments().stream().toList()));
            postVOS.add(postVO);
        }
        return postVOS;
    }

    @Override
    public List<PostVO> searchPost(SearchForm searchForm) {
        Pageable pageable = PageRequest.of(searchForm.getPageIndex()-1,searchForm.getPageSize(), Sort.by("datePost").descending());
        List<Post> posts = postRepository.findByContentLike("%"+searchForm.getText()+"%",pageable);
        List<PostVO> postVOS = new ArrayList<>();
        for(Post post : posts){
            PostVO postVO = new PostVO();
            postVO.setId(post.getId());
            postVO.setUser(post.getUser().getName());
            postVO.setTimePost(post.getDatePost());
            postVO.setContentPost(post.getContent());
            postVO.setCommentVOS(getComment(post.getComments().stream().toList()));
            postVOS.add(postVO);
        }
        return postVOS;
    }

    @Override
    public Boolean insertPost(AddPostForm addPostForm) {
        Post post = new Post();
        post.setCreated_by("truongtv");
        post.setModified_by("truongtv");
        post.setContent(addPostForm.getContent());
        post.setDatePost(LocalDate.now());
        // fake data
        User user = new User();
        user.setId(1l);
        post.setUser(user);
        postRepository.save(post);
        return true;
    }

    private List<CommentVO> getComment(List<Comment> comments){
        List<CommentVO> commentVOS = new ArrayList<>();
        for(int i = 0 ; i < comments.size(); i++){
            if(comments.get(i).getLevel()==1){
                CommentVO commentVO = new CommentVO();
                commentVO.setId(comments.get(i).getId());
                commentVO.setContent(comments.get(i).getContent());
                commentVO.setTimeComment(comments.get(i).getDateComment());
                commentVO.setUser(comments.get(i).getUser().getName());
                commentVO.setLevel(comments.get(i).getLevel());
                commentVO.setCommentVOS(getCommentChild(commentVO.getId(),comments.stream().filter(comment -> commentVO.getLevel().intValue() < comment.getLevel().intValue()).toList()));
                commentVOS.add(commentVO);
            }
        }
        return commentVOS;
    }
    private List<CommentVO> getCommentChild(Long idParent,List<Comment> comments){
        List<CommentVO> commentVOS = new ArrayList<>();
        for(int i = 0 ; i < comments.size(); i++){
            if(comments.get(i).getIdParent().equals(idParent)){
                CommentVO commentVO = new CommentVO();
                commentVO.setId(comments.get(i).getId());
                commentVO.setContent(comments.get(i).getContent());
                commentVO.setTimeComment(comments.get(i).getDateComment());
                commentVO.setUser(comments.get(i).getUser().getName());
                commentVO.setLevel(comments.get(i).getLevel());
                commentVO.setCommentVOS(getCommentChild(commentVO.getId(),comments.stream().filter(comment -> commentVO.getLevel().intValue() < comment.getLevel().intValue()).toList()));
                commentVOS.add(commentVO);
            }
        }
        return commentVOS;
    }
}
