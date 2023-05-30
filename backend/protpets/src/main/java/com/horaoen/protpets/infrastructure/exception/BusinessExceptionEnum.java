package com.horaoen.protpets.infrastructure.exception;

import com.horaoen.protpets.infrastructure.response.BaseErrorInfoInterface;

public enum BusinessExceptionEnum implements BaseErrorInfoInterface {

    USER_ALREADY_EXIST("1000", "用户已存在");
    private final String resultCode;

    private final String resultMsg;

    BusinessExceptionEnum(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public String getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
