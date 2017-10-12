package com.second.api.dao.user;

import org.apache.ibatis.annotations.Param;

import com.second.api.model.user.User;

public interface UserDao {

	User getUserInfo(@Param("names")String name);
}
