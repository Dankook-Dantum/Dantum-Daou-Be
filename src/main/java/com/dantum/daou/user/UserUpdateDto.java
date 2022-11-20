package com.dantum.daou.user;

import com.dantum.daou.util.AesEncryptUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateDto {
    private String name;
    private String profileUrl;
    private String email;
    private String password;
    private String phone;
    private String position;
    private String office;
    private String officeNumber;
    private String introduce;
    private String mbti;

    @Builder
    public UserUpdateDto(UserRequestDto requestDto, AesEncryptUtil aesEncryptUtil) throws Exception {
        this.name = aesEncryptUtil.encryptAES256(requestDto.getName());
        this.profileUrl = requestDto.getProfileUrl();
        this.email = aesEncryptUtil.encryptAES256(requestDto.getEmail());
        this.password = aesEncryptUtil.encryptAES256(requestDto.getPassword());
        this.phone = requestDto.getPhone();
        this.position = requestDto.getPosition();
        this.office = requestDto.getOffice();
        this.officeNumber = requestDto.getOfficeNumber();
        this.introduce = requestDto.getIntroduce();
        this.mbti = requestDto.getMbti();
    }
}
