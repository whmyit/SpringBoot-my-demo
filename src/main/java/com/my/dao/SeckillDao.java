package com.my.dao;

import com.my.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 12:22  2018/1/12
 */
@Repository
public interface SeckillDao {
    /**
     * 减库存
     * @param id
     * @param killtime
     * @return 如果影响行数>1 表示更新的行数
     */
    int reduceNumber(@Param("seckillId") Long id,@Param("killTime")  Date killtime);

    /**
     * 查询秒杀库存实体
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);


    /**
     * 查询所有库存
     * @param offet
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offet,@Param("limit") int limit);
}
