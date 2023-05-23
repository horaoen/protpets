package com.horaoen.protpets.infrastructure;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GlobalConfiguration {

    @Bean
    public HttpMessageConverters customHttpMessageConverter() {
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }
}
