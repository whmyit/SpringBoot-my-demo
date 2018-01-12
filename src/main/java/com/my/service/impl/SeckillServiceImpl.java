package com.my.service.impl;

import com.my.dao.SeckillDao;
import com.my.dto.Exposer;
import com.my.dto.SeckillExecution;
import com.my.entity.Seckill;
import com.my.exception.RepeatKillException;
import com.my.exception.SeckillCloseException;
import com.my.exception.SeckillException;
import com.my.service.SeckillService;
import com.my.util.Md5Utill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * @Author: whmyit@163.com
 * @Description:
 * @Date: Created in 15:02  2018/1/12
 */
public class SeckillServiceImpl implements SeckillService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    private SeckillDao seckillDao;




    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    @Override
    public Seckill getSeckillById(long id) {
        return seckillDao.queryById(id);
    }

    @Override
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckil=getSeckillById(seckillId);
        if(seckil==null){
            return new Exposer(false,seckillId);
        }
        Date startTime=seckil.getStartTime();

        Date endtime=seckil.getEndTime();

        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime()
                || nowTime.getTime() > endtime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(),
                    startTime.getTime(), endtime.getTime());
        }else {
            //转换特定字符串的过程  不可逆
            String md5 = Md5Utill.getMd5(seckillId);
            return new Exposer(true, md5, seckillId);
        }

    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        //首先判断MD5是否存在或者是否正确
        if(md5 ==null ||!md5.equals(Md5Utill.getMd5(seckillId))){
              throw new SeckillException("sekill data rewrite");
        }

        //减库存

        //记录秒杀记录

        return null;
    }
}
