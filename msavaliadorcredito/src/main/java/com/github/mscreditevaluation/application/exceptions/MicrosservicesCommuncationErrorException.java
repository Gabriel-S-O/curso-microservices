package com.github.mscreditevaluation.application.exceptions;

import lombok.Getter;

public class MicrosservicesCommuncationErrorException extends Exception{

    @Getter
    private Integer status;

    public MicrosservicesCommuncationErrorException(Integer status, String message) {
        super(message);
        this.status = status;
    }
}
