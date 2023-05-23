package com.horaoen.protpets.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends io.mybatis.mapper.Mapper<User, String> {
}
