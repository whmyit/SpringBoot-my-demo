package com.my.dao;

import com.my.entity.Seckill;
import com.my.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description: 秒杀
 * @Date: Created in 12:22  2018/1/12
 */
@Repository
public interface SuccesskilleDao {
    /**
     * 插入购买明细
     * @param id
     * @param userPhone
     * @return 插入的行数 0等于失败
     */
    int insertSuccessKilled(@Param("seckillId") Long seckillId,@Param("userPhone") long userPhone);

    /**
     * 根据id查询SuccessKilled 并携带秒杀产品实体对象
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

}
