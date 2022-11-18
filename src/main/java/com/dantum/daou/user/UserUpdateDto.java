package com.dantum.daou.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
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
    public UserUpdateDto(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.profileUrl = requestDto.getProfileUrl();
        this.email = requestDto.getEmail();
        this.phone = requestDto.getPhone();
        this.position = requestDto.getPosition();
        this.office = requestDto.getOffice();
        this.officeNumber = requestDto.getOfficeNumber();
        this.introduce = requestDto.getIntroduce();
        this.mbti = requestDto.getMbti();
    }
}
