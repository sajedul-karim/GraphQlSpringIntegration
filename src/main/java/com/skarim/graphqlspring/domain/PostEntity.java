package com.skarim.graphqlspring.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "post", schema = "blog")
public class PostEntity {
    private int id;
    private String title;
    private String description;
    private String publishedDate;
    private String userId;
    private Collection<CommentsEntity> commentsById;
    private UserEntity userById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "published_date")
    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, publishedDate, userId);
    }

    @OneToMany(mappedBy = "postByPostId")
    public Collection<CommentsEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentsEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false , insertable=false, updatable=false)
    public UserEntity getUserById() {
        return userById;
    }

    public void setUserById(UserEntity userById) {
        this.userById = userById;
    }
}
