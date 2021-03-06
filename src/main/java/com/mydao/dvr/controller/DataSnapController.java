package com.mydao.dvr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydao.dvr.dao.DataSnapLaneMapper;
import com.mydao.dvr.dao.DataSnapMapper;
import com.mydao.dvr.dao.SiteInfoMapper;
import com.mydao.dvr.entrty.DataSnap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/snap")
public class DataSnapController {

    @Autowired
    private DataSnapMapper dataSnapMapper;
    @Autowired
    private DataSnapLaneMapper dataSnapLaneMapper;
    @Autowired
    private SiteInfoMapper siteInfoMapper;

    ObjectMapper om = new ObjectMapper();

    /**
     * 主线记录
     * @param dataSnap
     * @return
     * @throws Exception
     */
    @PostMapping(value="/list3")
    public String findList(@RequestBody DataSnap dataSnap) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        dataSnap.setBeginRow(dataSnap.getPageIndex()*dataSnap.getPageSize()-dataSnap.getPageSize()+1);
        dataSnap.setEndRow(dataSnap.getBeginRow()+dataSnap.getPageSize());
        resultMap.put("pageIndex",dataSnap.getPageIndex());
        resultMap.put("pageSize",dataSnap.getPageSize());
        if (dataSnap.getStart()!=null){
            dataSnap.setStart(dataSnap.getStart().replaceAll("/","-").replaceAll("T"," "));
            if (dataSnap.getStart().equals("")){
                dataSnap.setStart(null);
            }
        }
        if (dataSnap.getEnd()!=null){
            dataSnap.setEnd(dataSnap.getEnd().replaceAll("/","-").replaceAll("T"," "));
            if (dataSnap.getEnd().equals("")){
                dataSnap.setEnd(null);
            }
        }
        dataSnap.setNetSiteNo("1");
        List<DataSnap> list = dataSnapMapper.findList(dataSnap);
        Integer count = dataSnapMapper.count(dataSnap);
        List<String> pl = new ArrayList<>();
        for (int i = 1; i < count/Integer.parseInt(resultMap.get("pageSize").toString())+2;i++){
            pl.add(i+"");
        }
        resultMap.put("status","1");
        resultMap.put("msg","执行成功！");
        resultMap.put("list",list);
        resultMap.put("count",count);
        return om.writeValueAsString(resultMap);
    }


    /**
     * 匝道记录
     * @param dataSnap
     * @return
     * @throws Exception
     */
    @PostMapping(value="/list2")
    public String findList1(@RequestBody DataSnap dataSnap) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        dataSnap.setBeginRow(dataSnap.getPageIndex()*dataSnap.getPageSize()-dataSnap.getPageSize()+1);
        dataSnap.setEndRow(dataSnap.getBeginRow()+dataSnap.getPageSize());
        resultMap.put("pageIndex",dataSnap.getPageIndex());
        resultMap.put("pageSize",dataSnap.getPageSize());
        if (dataSnap.getStart()!=null){
            dataSnap.setStart(dataSnap.getStart().replaceAll("/","-").replaceAll("T"," "));
            if (dataSnap.getStart().equals("")){
                dataSnap.setStart(null);
            }
        }
        if (dataSnap.getEnd()!=null){
            dataSnap.setEnd(dataSnap.getEnd().replaceAll("/","-").replaceAll("T"," "));
            if (dataSnap.getEnd().equals("")){
                dataSnap.setEnd(null);
            }
        }
        dataSnap.setNetSiteNo(dataSnap.getStartSite()+"0000");//匝道摄像机
        List<DataSnap> list = dataSnapMapper.findList(dataSnap);
        Integer count = dataSnapMapper.count(dataSnap);
        List<String> pl = new ArrayList<>();
        for (int i = 1; i < count/Integer.parseInt(resultMap.get("pageSize").toString())+2;i++){
            pl.add(i+"");
        }
        resultMap.put("status","1");
        resultMap.put("msg","执行成功！");
        resultMap.put("list",list);
        resultMap.put("count",count);
        return om.writeValueAsString(resultMap);
    }

    /**
     * 车道记录
     * @param dataSnap
     * @return
     * @throws Exception
     */
    @PostMapping(value="/list1")
    public String findList2(@RequestBody DataSnap dataSnap) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        dataSnap.setBeginRow(dataSnap.getPageIndex()*dataSnap.getPageSize()-dataSnap.getPageSize()+1);
        dataSnap.setEndRow(dataSnap.getBeginRow()+dataSnap.getPageSize());
        resultMap.put("pageIndex",dataSnap.getPageIndex());
        resultMap.put("pageSize",dataSnap.getPageSize());
        if (dataSnap.getStart()!=null){
            dataSnap.setStart(dataSnap.getStart().replaceAll("/","-").replaceAll("T"," "));
            if (dataSnap.getStart().equals("")){
                dataSnap.setStart(null);
            }
        }
        if (dataSnap.getEnd()!=null){
            dataSnap.setEnd(dataSnap.getEnd().replaceAll("/","-").replaceAll("T"," "));
            if (dataSnap.getEnd().equals("")){
                dataSnap.setEnd(null);
            }
        }
        dataSnap.setNetSiteNo(dataSnap.getStartSite());
        List<DataSnap> list = dataSnapLaneMapper.findList(dataSnap);
        Integer count = dataSnapLaneMapper.count(dataSnap);
        List<String> pl = new ArrayList<>();
        for (int i = 1; i < count/Integer.parseInt(resultMap.get("pageSize").toString())+2;i++){
            pl.add(i+"");
        }
        resultMap.put("status","1");
        resultMap.put("msg","执行成功！");
        resultMap.put("list",list);
        resultMap.put("count",count);
        return om.writeValueAsString(resultMap);
    }

    @GetMapping(value="/info/{id}")
    public String info(@RequestParam String id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","1");
        resultMap.put("msg","执行成功！");
        resultMap.put("data",dataSnapMapper.selectByPrimaryKey(id));
        return om.writeValueAsString(resultMap);
    }

    @GetMapping(value="/laneInfo/{id}")
    public String laneInfo(@RequestParam String id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","1");
        resultMap.put("msg","执行成功！");
        resultMap.put("data",dataSnapLaneMapper.selectByPrimaryKey(id));
        return om.writeValueAsString(resultMap);
    }

    @GetMapping(value="/getSiteInfo")
    public String getSiteInfo() throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","1");
        resultMap.put("msg","执行成功！");
        resultMap.put("data",siteInfoMapper.findList());
        return om.writeValueAsString(resultMap);
    }

}
