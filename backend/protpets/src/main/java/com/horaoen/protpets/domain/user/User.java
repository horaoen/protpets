package com.horaoen.protpets.domain.user;

import com.horaoen.protpets.infrastructure.database.AuditEntity;
import io.mybatis.provider.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity.Table("user")
@Builder
@Data
public class User extends AuditEntity {
    @Entity.Column(id = true)
    private String id;

    @Entity.Column("nick_name")
    private String nickName;

    @Entity.Column("email")
    private String email;
    
    @Entity.Column("phone")
    private String phone;
}
