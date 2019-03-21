package com.mydao.dvr.dao;

import com.mydao.dvr.entrty.CodeVideoCamera;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CodeVideoCameraMapper {

    int deleteByPrimaryKey(String id);

    int insertSelective(CodeVideoCamera record);

    CodeVideoCamera selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CodeVideoCamera record);
}