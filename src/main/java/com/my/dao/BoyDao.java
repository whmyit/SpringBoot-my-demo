package com.my.dao;

import com.my.entity.Boy;
import org.springframework.stereotype.Repository;


import java.util.List;



/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 17:27  2018/1/11
 */
@Repository
public interface BoyDao {
    List<Boy> findAll();
}
