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
        if (requestDto.getName() != null) this.name = aesEncryptUtil.encryptAES256(requestDto.getName());
        if (requestDto.getProfileUrl() != null) this.profileUrl = requestDto.getProfileUrl();
        if (requestDto.getEmail() != null) this.email = aesEncryptUtil.encryptAES256(requestDto.getEmail());
        if (requestDto.getPassword() != null) this.password = aesEncryptUtil.encryptAES256(requestDto.getPassword());
        if (requestDto.getPhone() != null) this.phone = requestDto.getPhone();
        if (requestDto.getPosition() != null) this.position = requestDto.getPosition();
        if (requestDto.getOffice() != null) this.office = requestDto.getOffice();
        if (requestDto.getOfficeNumber() != null) this.officeNumber = requestDto.getOfficeNumber();
        if (requestDto.getIntroduce() != null) this.introduce = requestDto.getIntroduce();
        if (requestDto.getMbti() != null) this.mbti = requestDto.getMbti();
    }
}
