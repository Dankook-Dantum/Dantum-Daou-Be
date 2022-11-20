package com.dantum.daou.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserDto {
    @ApiModelProperty(example = "1")
    private Long userIdx;
    @ApiModelProperty(example = "김다우 사원")
    private String fullName;
    @ApiModelProperty(example = "https://s3.ap-northeast-2.amazonaws.com/profileUrl.jpg")
    private String profileUrl;
    @ApiModelProperty(example = "abcd1234@gmail.com")
    private String email;
    @ApiModelProperty(example = "010-1234-5678")
    private String phone;
    @ApiModelProperty(example = "개발팀")
    private String office;
    @ApiModelProperty(example = "522")
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
