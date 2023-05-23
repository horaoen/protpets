package com.horaoen.protpets.domain.user;

import java.util.Objects;

public record RegisterDto(
        String nickName,
        String phone
) {
    public RegisterDto {
        Objects.requireNonNull(nickName);
        Objects.requireNonNull(phone);
    }
}