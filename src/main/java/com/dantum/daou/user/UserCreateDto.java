package com.dantum.daou.user;

import com.dantum.daou.util.AesEncryptUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;
    private String password;

    @Builder
    public UserCreateDto(UserRequestDto requestDto, AesEncryptUtil aesEncryptUtil) throws Exception {
        this.name = aesEncryptUtil.encryptAES256(requestDto.getName());
        this.email =  aesEncryptUtil.encryptAES256(requestDto.getEmail());
        this.password = aesEncryptUtil.encryptAES256(requestDto.getPassword());
    }

    public User toEntity() {
        return User.builderForCreate()
                .name(name)
                .email(email)
                .password(password).build();
    }
}
