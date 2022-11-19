package com.dantum.daou.issue;


import com.dantum.daou.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @Column(name = "issue_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issueIdx;


    // 이슈 제목

    @Column(name = "title")
    private String title;

    // 이슈 내용

    @Column(name = "content")
    private String content;

    // 이슈 라벨
    @NotNull
    @Column(name = "label")
    private int label;

    // user_idx : 외래키
    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;


    // 생성일
    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;


    @Builder
    public Issue(String title, String content, int label, User user){
        this.title = title;
        this.content = content;
        this.label = label;
        this.user = user;
    }

    public void update(IssueRequestDto requestDto) {
        if (requestDto.getTitle() != null) this.title = requestDto.getTitle();
        if (requestDto.getContent() != null) this.content = requestDto.getContent();
        if (Integer.valueOf(requestDto.getLabel()) != null) this.label = requestDto.getLabel();
    }
}
