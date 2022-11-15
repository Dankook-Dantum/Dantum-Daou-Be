package com.dantum.daou.vote;


import com.dantum.daou.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class VoteCreateRequestDto {

    private User user;
    private String title;
    private int type; // (찬성 / 반대)
}
