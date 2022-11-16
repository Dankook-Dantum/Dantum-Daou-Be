package com.dantum.daou.issue;


import com.dantum.daou.user.User;
import com.dantum.daou.vote.Vote;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class IssueCreateDto {

    private String title;

    private String content;

    private int label;   // enum 생각해야 함

    private User user;

    @Builder // enum 반영 해야
    public IssueCreateDto(String title,String content, int label, User user){ //
        this.title = title;
        this.content = content;
        this.label = label;
        this.user = user;
    }


    public Issue toEntity(){
        return Issue.builder()
                .title(title)
                .content(content)
                .label(label)
                .user(user)
                .build();
    }
}
