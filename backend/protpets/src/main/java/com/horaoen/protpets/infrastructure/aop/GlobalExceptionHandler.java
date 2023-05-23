package com.horaoen.protpets.infrastructure.aop;

import com.horaoen.protpets.infrastructure.exception.BizException;
import com.horaoen.protpets.infrastructure.response.UnifiedResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    public UnifiedResponse bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return UnifiedResponse.error(e.getErrorCode(), e.getErrorMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public UnifiedResponse exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常！原因是:", e);
        return UnifiedResponse.error(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
