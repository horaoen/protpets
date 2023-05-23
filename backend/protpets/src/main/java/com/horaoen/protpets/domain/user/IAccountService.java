package com.horaoen.protpets.domain.user;

import io.mybatis.service.BaseService;

public interface IAccountService extends BaseService<User, String> {

    void register(RegisterDto register);
}
