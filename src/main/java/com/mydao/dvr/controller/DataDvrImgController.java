package com.mydao.dvr.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mydao.dvr.dao.CodeVideoCameraMapper;
import com.mydao.dvr.dao.DataSnapLaneMapper;
import com.mydao.dvr.entrty.CodeVideoCamera;
import com.mydao.dvr.entrty.DataSnapLane;
import com.mydao.dvr.vo.DSVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class DataDvrImgController {

    private final Logger log = LoggerFactory.getLogger(DataDvrImgController.class);

    @Autowired
    private DataSnapLaneMapper dataSnapLaneMapper;

    @Autowired
    private CodeVideoCameraMapper codeVideoCameraMapper;

    ObjectMapper om = new ObjectMapper();

    @GetMapping("/detail")
    public String detail(@RequestParam String plateNo) throws Exception{
        DataSnapLane ds = dataSnapLaneMapper.selectByPlateNo(plateNo);
        DSVO dsvo = new DSVO();
        if (ds!=null){
            dsvo.setCreateTime(ds.getCreateTime());
            dsvo.setDvrName(ds.getDvrID());
            dsvo.setId(ds.getId());
            dsvo.setNetSiteNo(ds.getNetSiteNo());
            return om.writeValueAsString(dsvo);
        }else{
            return om.writeValueAsString("NoData!");
        }
    }

    @PostMapping("/update")
    public String update(@RequestParam String id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        DataSnapLane ds = new DataSnapLane();
        ds.setId(id);
        ds.setState("1");
        if (dataSnapLaneMapper.updateByPrimaryKeySelective(ds)>0){
            resultMap.put("status","1");
            resultMap.put("msg","success");
            return  om.writeValueAsString(resultMap);
        }
        resultMap.put("status","0");
        resultMap.put("msg","error");
        return om.writeValueAsString(resultMap);
    }

    /**
     * 添加摄像机
     * @param codeVideoCamera
     * @return
     */
    @PostMapping("/insertCamera")
    public String insert(@RequestBody CodeVideoCamera codeVideoCamera) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        codeVideoCamera.setId(UUID.randomUUID().toString().replaceAll("-",""));
        //codeVideoCamera.setState("1");
        if (codeVideoCameraMapper.selectByDvrId(codeVideoCamera.getDvrID())!=null){
            resultMap.put("status","0");
            resultMap.put("msg","Data already existed");
            return om.writeValueAsString(resultMap);
        }
        if (codeVideoCameraMapper.insertSelective(codeVideoCamera)>0){
            resultMap.put("status","1");
            resultMap.put("msg","success");
            return om.writeValueAsString(resultMap);
        }
        resultMap.put("status","0");
        resultMap.put("msg","error");
        return om.writeValueAsString(resultMap);
    }

    /**
     * 更新摄像机状态
     * @param codeVideoCamera
     * @return
     * @throws Exception
     */
    @PostMapping("/updateCameraState")
    public String updateCamera(@RequestBody CodeVideoCamera codeVideoCamera) throws  Exception{
        Map<String,Object> resultMap = new HashMap<>();
        if (codeVideoCameraMapper.updateByPrimaryKeySelective(codeVideoCamera)>0){
            resultMap.put("status","1");
            resultMap.put("msg","success");
            return om.writeValueAsString(resultMap);
        }
        resultMap.put("status","0");
        resultMap.put("msg","error");
        return om.writeValueAsString(resultMap);
    }

    @PostMapping("/getList")
    public String getList(@RequestBody CodeVideoCamera codeVideoCamera) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        codeVideoCamera.setBeginRow(codeVideoCamera.getPageIndex()*codeVideoCamera.getPageSize()-codeVideoCamera.getPageSize()+1);
        codeVideoCamera.setEndRow(codeVideoCamera.getBeginRow()+codeVideoCamera.getPageSize());
        List<CodeVideoCamera> lc = codeVideoCameraMapper.selectList(codeVideoCamera);
        Integer count = codeVideoCameraMapper.count(codeVideoCamera);
        resultMap.put("list",lc);
        resultMap.put("count",count);
        resultMap.put("status","1");
        resultMap.put("msg","success");
        return om.writeValueAsString(resultMap);
    }

    @GetMapping("/getVideoInfo")
    public String getVideoInfo(@RequestParam String dvrID) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("status","1");
        resultMap.put("msg","success");
        resultMap.put("data",codeVideoCameraMapper.selectByDvrId(dvrID));
        return om.writeValueAsString(resultMap);
    }

    @PostMapping("/deleteDvr")
    public String deleteDvr(@RequestParam String id) throws Exception{
        Map<String,Object> resultMap = new HashMap<>();
        if (codeVideoCameraMapper.deleteByPrimaryKey(id)>0){
            resultMap.put("status","1");
            resultMap.put("msg","success");
            return om.writeValueAsString(resultMap);
        }
        resultMap.put("status","0");
        resultMap.put("msg","error");
        return om.writeValueAsString(resultMap);
    }
}
