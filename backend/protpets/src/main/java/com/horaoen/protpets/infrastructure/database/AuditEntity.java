package com.horaoen.protpets.infrastructure.database;

import io.mybatis.provider.Entity;
import lombok.Data;

import java.util.Date;

/**
 * 审计基类
 */
@Data
public class AuditEntity {
    @Entity.Column(value = "update_time", updatable = false, insertable = false)
    private Date updateTime;

    @Entity.Column(value = "create_time", updatable = false, insertable = false)
    private Date createTime;
}
