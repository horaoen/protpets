package com.horaoen.protpets.domain.user;

import com.horaoen.protpets.infrastructure.exception.BizExceptionEnum;
import com.horaoen.protpets.infrastructure.exception.BizException;

public class UserAlreadyExistException extends BizException {
    public UserAlreadyExistException() {
        super(BizExceptionEnum.USER_ALREADY_EXIST);
    }

    public UserAlreadyExistException(String errMsg) {
        this();
        this.errorMsg = errMsg;
    }
}
