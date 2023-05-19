package com.horaoen.protpets.domin.user;

import cn.hutool.core.lang.UUID;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@Tag(name = "账号管理")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @GetMapping("/test")
    @Operation(summary = "测试")
    public void register() {
        User user = User.builder()
                .id(UUID.fastUUID().toString())
                .email("123@gmail.com")
                .nickName("123")
                .build();
        this.accountService.save(user);
        System.out.println(user.getId());
        System.out.println(user.getCreateTime());
    }
}
