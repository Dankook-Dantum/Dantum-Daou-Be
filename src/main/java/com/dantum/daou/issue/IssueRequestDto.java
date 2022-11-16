package com.dantum.daou.issue;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IssueRequestDto {

    private String title;

    private String content;

    private int label;

    @Builder
    public IssueRequestDto(String title, String content, int label){
        this.title = title;
        this.content =  content;
        this.label = label;
    }
}
