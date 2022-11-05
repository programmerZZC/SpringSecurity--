package com.springsecurity.exception;

import com.springsecurity.enums.ResultEnum;

public class ReportException extends RuntimeException {

    private Integer code;

    public ReportException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ReportException(Integer code,String message){
        super(message);
        this.code = code;
    }
}
