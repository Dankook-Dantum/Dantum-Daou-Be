package com.dantum.daou.user;


import com.dantum.daou.stack.Stack;
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

    @NotNull
    @Column(name="profile_url")
    private String profileUrl;

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

    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    @BatchSize(size = 100)
    private List<Stack> stacks = new ArrayList<>();

    @Builder
    public User(String name, String profileUrl, String email, String phone, String rank, String office, String officeNumber, String introduce, String mbti) {
        this.name = name;
        this.profileUrl = profileUrl;
        this.email = email;
        this.phone = phone;
        this.rank = rank;
        this.office = office;
        this.officeNumber = officeNumber;
        this.introduce = introduce;
        this.mbti = mbti;
    }
}
