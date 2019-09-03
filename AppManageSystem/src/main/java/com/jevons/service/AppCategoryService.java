package com.jevons.service;

import com.jevons.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
     List<AppCategory> queryAllLevelOne();


    List<AppCategory> queryLevelTwoByLevelOne(Long id);

    List<AppCategory> queryLevelThreeByLevelTwo(Long id);
}
