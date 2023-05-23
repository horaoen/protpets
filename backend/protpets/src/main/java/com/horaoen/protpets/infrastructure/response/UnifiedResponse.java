package com.horaoen.protpets.infrastructure.response;

import com.horaoen.protpets.infrastructure.GlobalConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnifiedResponse {
    private String code;

    private String message;

    private Object data;

    public UnifiedResponse(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public static UnifiedResponse success() {
        return success(null);
    }

    public static UnifiedResponse success(Object data) {
        return UnifiedResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(HttpStatus.OK.getReasonPhrase())
                .data(data).build();
    }
    
    public static UnifiedResponse success(String msg) {
        return UnifiedResponse.builder()
                .code(String.valueOf(HttpStatus.OK.value()))
                .message(msg)
                .build();
    }

    public static UnifiedResponse error(BaseErrorInfoInterface errorInfo) {
        return UnifiedResponse.builder()
                .code(errorInfo.getResultCode())
                .message(errorInfo.getResultMsg())
                .build();
    }

    public static UnifiedResponse error(String code, String message) {
        return UnifiedResponse.builder()
                .code(code)
                .message(message)
                .build();
    }

    public static UnifiedResponse error(String message) {
        return UnifiedResponse.builder()
                .code(GlobalConstant.ERROR_CODE)
                .message(message)
                .build();
    }
}
