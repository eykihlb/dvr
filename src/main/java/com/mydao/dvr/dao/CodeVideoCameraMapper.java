package com.mydao.dvr.dao;

import com.mydao.dvr.entrty.CodeVideoCamera;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CodeVideoCameraMapper {
    int deleteByPrimaryKey(String id);

    int insertSelective(CodeVideoCamera record);

    CodeVideoCamera selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(CodeVideoCamera record);

    List<CodeVideoCamera> selectList(CodeVideoCamera record);
    Integer count(CodeVideoCamera record);

    CodeVideoCamera selectByDvrId(String dvrID);

}