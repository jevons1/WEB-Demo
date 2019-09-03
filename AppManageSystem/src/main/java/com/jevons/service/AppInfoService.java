package com.jevons.service;

import com.github.pagehelper.PageInfo;
import com.jevons.dto.AppInfoDTO;
import com.jevons.pojo.AppInfo;
import com.jevons.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoService {
    PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo pageInfo);

    List<DataDictionary> queryAllAppAtatus();

    List<DataDictionary> queryAllAppFlatforms();

    PageInfo<AppInfo> query(AppInfoDTO appInfoDTO);

    boolean add(AppInfo appInfo, long userId);

    boolean delete(Object id);


    AppInfo queryById(@Param("id") Long id);

    void update(AppInfo appInfo);

    AppInfo queryDetailById(Long id);
}
