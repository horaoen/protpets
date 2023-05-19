package com.horaoen.protpets.domin.user;

import com.horaoen.protpets.infrastructure.common.AuditEntity;
import io.mybatis.provider.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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
}
