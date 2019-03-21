package com.mydao.dvr.dao;


import com.mydao.dvr.entrty.DataSnap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DataSnapLaneMapper {
    
    DataSnap selectByPrimaryKey(String id);
    List<DataSnap> findList(DataSnap dataSnap);
    Integer count(DataSnap dataSnap);
}