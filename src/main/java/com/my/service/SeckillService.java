package com.my.service;

import com.my.dto.Exposer;
import com.my.dto.SeckillExecution;
import com.my.entity.Seckill;
import com.my.exception.RepeatKillException;
import com.my.exception.SeckillCloseException;
import com.my.exception.SeckillException;

import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description: 业务接口 站在使用者的角度使用接口
 *                 1.方法定义粒度
 *                 2.参数简练直接
 *                 3.返回类型友好
 * @Date: Created in 14:31  2018/1/12
 */
public interface SeckillService {


    /**
     * 查询所有秒杀记录
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 根据id获取秒杀
     * @param id
     * @return
     */
    Seckill getSeckillById(long id);


    /**
     * 秒杀开启输出秒杀地址接口
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);


    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;


}
