package com.my.dao;

import com.my.entity.Boy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 10:11  2018/1/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BoyDaoTest {

    @Autowired
    private BoyDao boyDao;

    @Test
    public void getAll() throws Exception {
       List<Boy> list= boyDao.findAll();
        for(int i=0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }

}