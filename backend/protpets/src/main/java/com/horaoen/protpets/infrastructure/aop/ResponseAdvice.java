package com.horaoen.protpets.infrastructure.aop;

import cn.hutool.json.JSONUtil;
import com.horaoen.protpets.infrastructure.response.IgnoreResponseAdvice;
import com.horaoen.protpets.infrastructure.response.UnifiedResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice(value = "com.horaoen.protpets.domain")
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        if (methodParameter.getDeclaringClass()
                .isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if(methodParameter.getMethod() != null) {
            return !methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class);
        } 
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (null == o) {
            return UnifiedResponse.success();
        } else if (o instanceof UnifiedResponse) {
            return o;
        } else if(o instanceof String){
            //o是message
            UnifiedResponse unifiedResponse = UnifiedResponse.success(o.toString());
            return JSONUtil.parse(unifiedResponse).toString();
        } else {
            // o是data
            return UnifiedResponse.success(o);
        }
    }
}
