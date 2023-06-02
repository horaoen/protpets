DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    username    VARCHAR(50)  NOT NULL PRIMARY KEY,
    password    VARCHAR(500) NOT NULL,
    enabled     BOOLEAN      NOT NULL,
    email       varchar(128) COMMENT '邮箱',
    phone       varchar(32)  NULL COMMENT '手机号',
    create_time timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
);

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities
(
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups`
(
    id         bigint AUTO_INCREMENT PRIMARY KEY,
    group_name varchar(50) NOT NULL
);

DROP TABLE IF EXISTS group_authorities;
CREATE TABLE group_authorities
(
    group_id  bigint      NOT NULL,
    authority varchar(50) NOT NULL,
    FOREIGN KEY (group_id) REFERENCES `groups` (id)
);

DROP TABLE IF EXISTS group_members;
CREATE TABLE group_members
(
    id       bigint AUTO_INCREMENT PRIMARY KEY,
    username varchar(50) NOT NULL,
    group_id bigint      NOT NULL,
    FOREIGN KEY (group_id) REFERENCES `groups` (id)
);
