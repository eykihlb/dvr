package com.mydao.dvr.dao;


import com.mydao.dvr.entrty.SiteInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SiteInfoMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(SiteInfo record);

    SiteInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SiteInfo record);
}