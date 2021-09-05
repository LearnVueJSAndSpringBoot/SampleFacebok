package com.example.SampleFacebook.service.impl;

import com.example.SampleFacebook.entity.Comment;
import com.example.SampleFacebook.entity.Post;
import com.example.SampleFacebook.entity.User;
import com.example.SampleFacebook.form.AddCommentForm;
import com.example.SampleFacebook.repository.CommentRepository;
import com.example.SampleFacebook.service.CommentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Boolean insertComment(AddCommentForm addCommentForm) {
        Comment comment = new Comment();
        comment.setCreated_by("truongtv");
        comment.setModified_by("truongtv");
        comment.setContent(addCommentForm.getContent());
        comment.setDateComment(LocalDate.now());
        comment.setLevel(addCommentForm.getLevel());
        comment.setIdParent(addCommentForm.getIdParentComment());
        Post post = new Post();
        post.setId(addCommentForm.getIdPost());
        comment.setPost(post);
        // fake data
        User user = new User();
        user.setId(1l);
        comment.setUser(user);
        commentRepository.save(comment);
        return true;
    }
}
