package com.mydao.dvr.dao;


import com.mydao.dvr.entrty.SiteInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface SiteInfoMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(SiteInfo record);

    SiteInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SiteInfo record);

    List<SiteInfo> findList();
}