package com.jevons.service.impl;

import com.jevons.mapper.AppCategoryMapper;
import com.jevons.pojo.AppCategory;
import com.jevons.service.AppCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("appCategoryService")
public class AppCategoryServiceImpl implements AppCategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;


    @Override
    public List<AppCategory> queryLevelThreeByLevelTwo(Long id) {
        return appCategoryMapper.queryLevelByParentId(id);
    }

    @Override
    public List<AppCategory> queryAllLevelOne() {
        return appCategoryMapper.queryAllLevelOne();
    }

    @Override
    public List<AppCategory> queryLevelTwoByLevelOne(Long id) {
        return appCategoryMapper.queryLevelByParentId(id);
    }
}
