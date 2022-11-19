package com.dantum.daou.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {



    // Common
    INVALID_INPUT_VALUE(400, "C001", " 유효하지 않은 값을 입력했습니다."),
    METHOD_NOT_ALLOWED(405, "C002", " 유효하지 않은 접근 방법입니다."),

    HANDLE_ACCESS_DENIED(404, "C006", "리소스를 찾을 수 없습니다."),

    // User
    NOT_EXIST_USER(404,"U001","해당 유저를 찾을 수 없습니다."),


    // Vote
    NOT_EXIST_VOTE(404,"V001","해당 투표가 존재하지 않습니다."),


    // Issue
    NOT_EXIST_ISSUE(404,"I001", "이슈가 존재하지 않습니다."),

    // Stack
    NOT_EXIST_STACK(404,"S001", "스택이 존재하지 않습니다."),
    ;


    private final int HttpStatus;
    private String code;
    private final String message;

}