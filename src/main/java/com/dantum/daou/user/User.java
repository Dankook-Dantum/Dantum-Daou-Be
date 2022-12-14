package com.dantum.daou.user;


import com.dantum.daou.issue.Issue;
import com.dantum.daou.stack.Stack;
import com.dantum.daou.vote.Vote;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

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
    private Long userIdx;

    @NotNull
    @Column(name="name")
    private String name;


    @Column(name="profile_url")
    private String profileUrl;

    @NotNull
    @Column(name="email")
    private String email;

    @NotNull
    @Column(name="password")
    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name="position")
    private String position;

    @Column(name="office")
    private String office;

    @Column(name="office_number")
    private String officeNumber;

    @Column(name="introduce")
    private String introduce;

    @Column(name="mbti")
    private String mbti;

    @NotNull
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<Stack> stacks = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<Issue> issues = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<Vote> votes = new ArrayList<>();

    @Builder(builderClassName = "builderForShow", builderMethodName = "builderForShow")
    public User(String name, String profileUrl, String email, String password, String phone, String position, String office, String officeNumber, String introduce, String mbti) {
        this.name = name;
        this.profileUrl = profileUrl;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.position = position;
        this.office = office;
        this.officeNumber = officeNumber;
        this.introduce = introduce;
        this.mbti = mbti;
    }

    @Builder(builderClassName = "builderForCreate", builderMethodName = "builderForCreate")
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void update(UserUpdateDto userUpdateDto) {
        if (userUpdateDto.getName() != null) this.name = userUpdateDto.getName();
        if (userUpdateDto.getProfileUrl() != null) this.profileUrl = userUpdateDto.getProfileUrl();
        if (userUpdateDto.getEmail() != null) this.email = userUpdateDto.getEmail();
        if (userUpdateDto.getPosition() != null) this.password = userUpdateDto.getPassword();
        if (userUpdateDto.getPhone() != null) this.phone = userUpdateDto.getPhone();
        if (userUpdateDto.getPosition() != null) this.position = userUpdateDto.getPosition();
        if (userUpdateDto.getOffice() != null) this.office = userUpdateDto.getOffice();
        if (userUpdateDto.getOfficeNumber() != null) this.officeNumber = userUpdateDto.getOfficeNumber();
        if (userUpdateDto.getIntroduce() != null) this.introduce = userUpdateDto.getIntroduce();
        if (userUpdateDto.getMbti() != null) this.mbti = userUpdateDto.getMbti();
    }


}
