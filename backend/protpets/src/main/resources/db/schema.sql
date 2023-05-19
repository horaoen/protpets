# user
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    id          varchar(64)        NOT NULL COMMENT 'id',
    nick_name   varchar(64)        NOT NULL COMMENT '昵称',
    email       varchar(128)       NOT NULL COMMENT '邮箱',
    create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    delete_mark int      DEFAULT 0 NULL COMMENT '删除标志',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
