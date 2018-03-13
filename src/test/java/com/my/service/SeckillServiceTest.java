package com.my.service;

import com.my.dao.SeckillDao;
import com.my.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


import static org.junit.Assert.*;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 11:44  2018/1/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillServiceTest {

    private final Logger log= LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {

      List<Seckill> list= seckillService.getSeckillList();
        log.info("list={}",list);
    }

    @Test
    public void getSeckillById() throws Exception {
    }

    @Test
    public void exportSeckillUrl() throws Exception {
    }

    @Test
    public void executeSeckill() throws Exception {
    }

}