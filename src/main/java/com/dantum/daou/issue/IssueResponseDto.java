package com.dantum.daou.issue;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class IssueResponseDto {

    private Long issueIdx;

    private String name; // 작성자

    private String title;
    private String labelName;

    private String content;

    private LocalDateTime createdAt;

    public IssueResponseDto(Issue entity){
        this.issueIdx = entity.getIssueIdx();
        this.name = entity.getUser().getName();
        this.title = entity.getTitle();
        this.labelName = LabelType.labelValueOfCode(entity.getLabel());
        this.content = entity.getContent();
        this.createdAt = entity.getCreatedAt();
    }
}
