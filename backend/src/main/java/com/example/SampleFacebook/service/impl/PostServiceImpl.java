package com.example.SampleFacebook.service.impl;

import com.example.SampleFacebook.entity.Comment;
import com.example.SampleFacebook.entity.Post;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
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
