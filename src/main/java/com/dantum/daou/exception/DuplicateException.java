package com.dantum.daou.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class DuplicateException extends RuntimeException {
    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public DuplicateException(String resourceName, String fieldName, String fieldValue){

        super(String.format("%s is exist already in %s : '%s'", fieldValue, resourceName, fieldName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
