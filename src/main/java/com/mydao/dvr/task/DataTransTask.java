package com.mydao.dvr.task;

import com.mydao.dvr.dao.DataSnapLaneMapper;
import com.mydao.dvr.dao.DataSnapMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataTransTask {

    private final Logger log = LoggerFactory.getLogger(DataTransTask.class);
    @Autowired
    private DataSnapLaneMapper dataSnapLaneMapper;
    @Autowired
    private DataSnapMapper dataSnapMapper;
    @PostConstruct
    public void start(){
        this.dataTrans();
    }

    @Async
    @Scheduled(cron="0 0 23 * * ?")    // 每天23点执行一次
    //@Scheduled(cron="0/5 * * * * ?")
    public void dataTrans(){
        log.info("开始执行数据删除任务！");
        dataSnapLaneMapper.deleteTimeoutData();
        dataSnapMapper.deleteTimeoutData();
        log.info("删除数据任务执行完毕！");
    }
}
