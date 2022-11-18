package com.dantum.daou.user;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String name;
    private String profileUrl;
    private String email;
    private String phone;
    private String position;
    private String office;
    private String officeNumber;
    private String introduce;
    private String mbti;

    @Builder
    public UserRequestDto(String name, String profileUrl, String email, String phone, String position, String office, String officeNumber, String introduce, String mbti) {
        this.name = name;
        this.profileUrl = profileUrl;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.office = office;
        this.officeNumber = officeNumber;
        this.introduce = introduce;
        this.mbti = mbti;
    }
}
