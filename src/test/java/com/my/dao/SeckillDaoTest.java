package com.my.dao;

import com.my.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 13:43  2018/1/12
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillDaoTest {

    @Autowired
    SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {

        List<Seckill> list= seckillDao.queryAll(0,100);
        for (int i=0;i<list.size();i++){
        System.out.println("---------- "+list.get(i));
        }
    }

    @Test
    public void queryById() throws Exception {
    }

    @Test
    public void queryAll() throws Exception {
    }

}