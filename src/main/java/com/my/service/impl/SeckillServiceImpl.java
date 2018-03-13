package com.my.service.impl;

import com.my.dao.SeckillDao;
import com.my.dao.SuccesskilleDao;
import com.my.dto.Exposer;
import com.my.dto.SeckillExecution;
import com.my.entity.Seckill;
import com.my.entity.SuccessKilled;
import com.my.enums.SeckillStatEnum;
import com.my.exception.RepeatKillException;
import com.my.exception.SeckillCloseException;
import com.my.exception.SeckillException;
import com.my.service.SeckillService;
import com.my.util.Md5Utill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

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

    private SuccesskilleDao successkilleDao;

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


    @Transactional
    @Override
    /**
     * 使用注解控制事务方法的优点:
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作RPC/HTTP请求或者剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作、只读操作不要事务控制
     */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        //首先判断MD5是否存在或者是否正确
        if(md5 ==null ||!md5.equals(Md5Utill.getMd5(seckillId))){
              throw new SeckillException("sekill data rewrite");
        }

        //执行秒杀逻辑： 减库存+增加购买明细
        Date nowTime=new Date();

        try{
            //否则更新了库存，秒杀成功,增加明细
            int insertCount=successkilleDao.insertSuccessKilled(seckillId,userPhone);
            //看是否该明细被重复插入，即用户是否重复秒杀
            if (insertCount<=0)
            {
                throw new RepeatKillException("seckill repeated");
            }else {

                //减库存,热点商品竞争 最后更新数据
                int updateCount=seckillDao.reduceNumber(seckillId,nowTime);
                if (updateCount<=0)
                {
                    //没有更新库存记录，说明秒杀结束 rollback
                    throw new SeckillCloseException("seckill is closed");
                }else {
                    //秒杀成功,得到成功插入的明细记录,并返回成功秒杀的信息 commit
                    SuccessKilled successKilled=successkilleDao.queryByIdWithSeckill(seckillId,userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }

            }


        }catch (SeckillCloseException e1)
        {
            throw e1;
        }catch (RepeatKillException e2)
        {
            throw e2;
        }catch (Exception e)
        {
            logger.error(e.getMessage(),e);
            //所以编译期异常转化为运行期异常
            throw new SeckillException("seckill inner error :"+e.getMessage());
        }

    }
}
