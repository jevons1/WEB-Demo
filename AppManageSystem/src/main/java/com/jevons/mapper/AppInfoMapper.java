package com.jevons.mapper;

import com.jevons.dto.AppInfoDTO;
import com.jevons.pojo.AppInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {

    //List<AppInfo> queryByDevUserId(@Param("devUserId") Long id);

    List<AppInfo> query(AppInfoDTO appInfoDTO);

    int add(AppInfo appInfo);

    int deleteById(@Param("id") Object id);

    AppInfo queryById(@Param("id") Long id);

    void updateById(AppInfo appInfo);

    AppInfo queryDetailById(@Param("id") Long id);

}