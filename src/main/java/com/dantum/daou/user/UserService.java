package com.dantum.daou.user;


import com.google.gson.JsonObject;
import com.kwakcompany.api.auth.SocialLogin;
import com.kwakcompany.api.auth.SocialLoginRepository;
import com.kwakcompany.api.auth.SocialLoginUpdateDto;
import com.kwakcompany.api.base.*;
import com.kwakcompany.api.security.PrincipalDetails;
import com.kwakcompany.api.util.AESEncryptUtils;
import com.kwakcompany.api.util.ClientUtils;
import com.kwakcompany.api.withdrawal.WithdrawalRequestDto;
import com.kwakcompany.api.withdrawal.WithdrawalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<Object> getUser(Long idx) {

        Authentication authentication = context.getAuthentication();
        PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Long currentUserIdx = principalDetails.getUserIdx();


        // 회원정보 DB에서 조회 후 출력을 위한 userResponseDto와 dataResponseDto 생성
        UserResponseDto userResponseDto;
        DataResponseDto dataResponseDto = null;
        try {
            User user = userRepository.findById(idx).orElseThrow(() -> new NullPointerException());

            if (user.getDeletedAt() != null) {
                throw new NullPointerException();
            }

            // userResponseDto 생성
            userResponseDto = UserResponseDto.builder()
                    .user(user)
                    .aesEncryptUtils(aesEncryptUtils).build();
            // dataResponseDto 생성
            dataResponseDto = new DataResponseDto(SuccessCode.OK_USER, userResponseDto);
        } catch (NullPointerException e) {
            JsonObject error = new JsonObject();
            final ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.NOT_FOUND_RESOURCE, e, error);

            return ResponseEntity.status(ErrorCode.NOT_FOUND_RESOURCE.getHttpStatus()).body(errorResponseDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(SuccessCode.OK_USER.getHttpStatus()).body(dataResponseDto);
    }


}
