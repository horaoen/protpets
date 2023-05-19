package com.horaoen.protpets.domin.user;

import io.mybatis.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AccountService
        extends AbstractService<User, String, UserMapper>
        implements IAccountService {
}
