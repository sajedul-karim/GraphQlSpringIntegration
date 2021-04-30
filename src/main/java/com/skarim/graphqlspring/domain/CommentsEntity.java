package com.skarim.graphqlspring.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comments", schema = "blog")
public class CommentsEntity {
    private int id;
    private String comment;
    private String commentDate;
    private int userId;
    private int postId;
    private UserEntity userByUserId;
    private PostEntity postByPostId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "comment_date")
    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "post_id")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, commentDate, userId, postId);
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false , insertable=false, updatable=false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false , insertable=false, updatable=false )
    public PostEntity getPostByPostId() {
        return postByPostId;
    }

    public void setPostByPostId(PostEntity postByPostId) {
        this.postByPostId = postByPostId;
    }
}
