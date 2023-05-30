package com.horaoen.protpets.domain.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Tag(name = "账号管理")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @PostMapping("/register")
    @Operation(summary = "注册")
    public String register(@RequestBody RegisterDto register) {
        this.accountService.register(register);
        return "注册成功";
    }
    
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
