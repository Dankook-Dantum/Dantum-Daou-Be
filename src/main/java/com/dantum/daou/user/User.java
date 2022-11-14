package com.dantum.daou.user;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="user_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_idx;

    @NotNull
    @Column(name="name")
    private String name;


    @NotNull
    @Column(name="profile_url")
    private String profile_url;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="phone")
    private String phone;

    @NotNull
    @Column(name="rank")
    private String rank;

    @NotNull
    @Column(name="office")
    private String description;

    @Column(name="office_number")
    private String office_number;

    @Column(name="introduce")
    private String introduce;

    @Column(name="stack_idx")
    private Long stack_idx;

    @Column(name="mbti")
    private String mbti;

    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @Column(name="status")
    private int status;





    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<File> files = new ArrayList<>();

    @Builder(builderMethodName = "builderForSignIn")
    public User(String encodedNickname, String encodedEmail, String password, short authType, String profileUrl, SocialLogin socialLogin) {
        Assert.notNull(encodedNickname, "nickname must not be null");
        Assert.notNull(password, "password must not be null");
        Assert.notNull(authType, "auth_type must not be null");
        Assert.notNull(profileUrl, "profile_url must not be null");

        this.nickname = encodedNickname;
        this.email = encodedEmail;
        this.password = password;
        this.authType = authType;
        this.profileUrl = profileUrl;
        this.socialLogin = socialLogin;
    }

    @Builder(builderMethodName = "builderForUpdate")
    public User(String nickname, String description, String profileUrl, String backgroundUrl, String instagramAccount, String facebookAccount) {
        this.nickname = nickname;
        this.description = description;
        this.profileUrl = profileUrl;
        this.backgroundUrl = backgroundUrl;
        this.instagramAccount = instagramAccount;
        this.facebookAccount = facebookAccount;
    }



}
