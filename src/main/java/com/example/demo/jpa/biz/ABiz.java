package com.example.demo.jpa.biz;

import com.example.demo.jpa.dao.ARepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.javasimon.aop.Monitored;

@Component("channelBiz")
@Transactional
@Monitored
@Log4j2
public class ABiz {
    @Resource
    @Qualifier("aDao")
    private ARepository aRepository;
}
