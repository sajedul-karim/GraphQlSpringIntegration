package com.skarim.graphqlspring.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "blog")
public class UserEntity {
    private int id;
    private String fullName;
    private String email;
    private String gender;
    private String dob;
    private String presentAddress;
    private String permanentAddress;
    private Collection<CommentsEntity> commentsById;
    private PostEntity postById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "dob")
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Basic
    @Column(name = "present_address")
    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    @Basic
    @Column(name = "permanent_address")
    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, gender, dob);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<CommentsEntity> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<CommentsEntity> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToOne(mappedBy = "userById")
    public PostEntity getPostById() {
        return postById;
    }

    public void setPostById(PostEntity postById) {
        this.postById = postById;
    }
}
