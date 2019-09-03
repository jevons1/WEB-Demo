package com.jevons.mapper;

import com.jevons.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {

    List<DataDictionary> queryAllAppAtatus();

    List<DataDictionary> queryAllAppFlatforms();

}