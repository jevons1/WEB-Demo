package com.jevons.mapper;

import com.jevons.pojo.DevUser;

import java.util.List;

public interface DevUserMapper {

    List<DevUser> queryByNamePwd(DevUser devUser);

}