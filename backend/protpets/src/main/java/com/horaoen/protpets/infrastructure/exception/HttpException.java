package com.horaoen.protpets.infrastructure.exception;

import com.horaoen.protpets.infrastructure.GlobalConstant;
import lombok.Getter;

@Getter
public class HttpException extends RuntimeException {
    public long errCode;
    public String message;
    
    public HttpException() {
        this.errCode = GlobalConstant.HTTP_ERROR_CODE;
        this.message = GlobalConstant.HTTP_ERROR_MESSAGE;
    }
    
    public HttpException(long errCode, String message) {
        this.errCode = errCode;
        this.message = message;
    }
}
