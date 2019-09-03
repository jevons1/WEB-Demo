package com.jevons.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jevons.constant.CommonCodeConstant;
import com.jevons.dto.AppInfoDTO;
import com.jevons.mapper.AppInfoMapper;
import com.jevons.mapper.DataDictionaryMapper;
import com.jevons.pojo.AppInfo;
import com.jevons.pojo.DataDictionary;
import com.jevons.pojo.DevUser;
import com.jevons.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;


    @Override
    public List<DataDictionary> queryAllAppAtatus() {
        return dataDictionaryMapper.queryAllAppAtatus();
    }

    @Override
    public List<DataDictionary> queryAllAppFlatforms() {
        return dataDictionaryMapper.queryAllAppFlatforms();
    }

    @Override
    public PageInfo<AppInfo> query(AppInfoDTO appInfoDTO) {
        if (appInfoDTO.getPageNum() == null){
            appInfoDTO.setPageNum(1);
        }
        PageHelper.startPage(appInfoDTO.getPageNum(), CommonCodeConstant.PAGE_SIZE);
        List<AppInfo> l = appInfoMapper.query(appInfoDTO);
        PageInfo<AppInfo> page = new PageInfo<AppInfo>(l);
        return page;
    }


    @Override
    public boolean add(AppInfo appInfo, long userId) {
        //先处理这些信息
        appInfo.setCreationDate(new Date());
        DevUser devUser = new DevUser();
        devUser.setId(userId);
        appInfo.setDevUser(devUser);
        appInfo.setCreatedBy(userId);
        DataDictionary dataDictionary = new DataDictionary();
        dataDictionary.setValueId(CommonCodeConstant.APP_STATUS_AUDITED);
        appInfo.setAppStatus(dataDictionary);
        int row = appInfoMapper.add(appInfo);
        return false;
    }

    @Override
    public boolean delete(Object id) {
        if (id != null){
            int row = appInfoMapper.deleteById(id);
            return row == 1 ? true:false;
        }
        return false;
    }



    @Override
    public AppInfo queryById(Long id) {
        return appInfoMapper.queryById(id);
    }

    @Override
    public void update(AppInfo appInfo) {

        appInfo.setModifyDate(new Date());
        appInfo.setUpdateDate(new Date());
        appInfoMapper.updateById(appInfo);
    }

    @Override
    public AppInfo queryDetailById(Long id) {
        return  appInfoMapper.queryDetailById(id);

    }


    @Override
    public PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo pageInfo) {


        //去第几页，页码的大小
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        AppInfoDTO a = new AppInfoDTO();
        a.setDevUserId(id);
        List<AppInfo> l = appInfoMapper.query(a);

        PageInfo<AppInfo> page = new PageInfo<AppInfo>(l);

        return page;
    }
}
