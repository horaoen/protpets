package com.horaoen.protpets.domin.user;

import io.mybatis.provider.Entity;

@Entity.Table("user")
public class User {
    private String id;
    
    private String nickName;
    
    private String email;
    
    private String createTime;
    
    private String updateTime;
}
