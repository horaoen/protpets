package com.horaoen.protpets.domain.user;

import cn.hutool.core.lang.UUID;
import io.mybatis.service.AbstractService;
import org.springframework.stereotype.Service;

@Service
public class AccountService
        extends AbstractService<User, String, UserMapper>
        implements IAccountService {
    private void registerCheck(RegisterDto register) {
        //用户昵称不重复，用户手机号不重复
        User byNickName = User.builder().nickName(register.nickName()).build();
        if(this.findOne(byNickName) != null) {
            throw new UserAlreadyExistException(AccountConstant.NICK_NAME_EXIST_MESSAGE);
        }
        User byPhone = User.builder().phone(register.phone()).build();
        if(this.findOne(byPhone) != null) {
            throw new UserAlreadyExistException(AccountConstant.PHONE_EXIST_MESSAGE);
        }
    }

    @Override
    public void register(RegisterDto register) {
        this.registerCheck(register);

        User user = User.builder()
                .id(UUID.fastUUID().toString())
                .nickName(register.nickName())
                .phone(register.phone())
                .build();
        this.save(user);
    }
}
