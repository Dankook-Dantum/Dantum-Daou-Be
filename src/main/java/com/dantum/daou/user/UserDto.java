package com.dantum.daou.user;

import com.dantum.daou.stack.Stack;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class UserDto {
    private Long userIdx;
    private String fullName;
    private String profileUrl;
    private String email;
    private String phone;
    private String office;
    private String officeNumber;


    @Builder
    public UserDto(User user) {
        this.userIdx = user.getUserIdx();
        this.fullName = user.getName() + user.getPosition();
        this.profileUrl = user.getProfileUrl();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.office = user.getOffice();
        this.officeNumber = user.getOfficeNumber();
    }
}
