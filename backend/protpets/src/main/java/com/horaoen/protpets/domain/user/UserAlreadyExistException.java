package com.horaoen.protpets.domain.user;

import com.horaoen.protpets.infrastructure.exception.BusinessExceptionEnum;
import com.horaoen.protpets.infrastructure.exception.BusinessException;

public class UserAlreadyExistException extends BusinessException {
    public UserAlreadyExistException() {
        super(BusinessExceptionEnum.USER_ALREADY_EXIST);
    }

    public UserAlreadyExistException(String errMsg) {
        this();
        this.errorMsg = errMsg;
    }
}
