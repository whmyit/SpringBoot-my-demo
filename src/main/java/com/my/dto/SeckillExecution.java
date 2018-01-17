package com.my.dto;


import com.my.entity.SuccessKilled;
import com.my.enums.SeckillStatEnum;

/**
 * @Author: whmyit@163.com
 * @Description: 秒杀结果
 * @Date: Created in 14:38  2018/1/12
 */
public class SeckillExecution {
	
	private long seckillId;

	//秒杀执行状态
	private int state;

	//状态标识
	private String stateInfo;

	//秒杀成功对象
	private SuccessKilled successKilled;


	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}



	//秒杀成功返回所有信息
	public SeckillExecution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = statEnum.getState();
		this.stateInfo = statEnum.getInfo();
		this.successKilled = successKilled;
	}






	public SeckillExecution(long seckillId, SeckillStatEnum state ) {
		super();
		this.seckillId = seckillId;
		this.state = state.getState();
		this.stateInfo = state.getInfo();
	}


	public SeckillExecution(long seckillId, int state, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.state = state;
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId, String stateInfo, SuccessKilled successKilled) {
		this.seckillId = seckillId;
		this.stateInfo = stateInfo;
		this.successKilled = successKilled;
	}

	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state
				+ ", stateInfo=" + stateInfo + ", successKilled="
				+ successKilled + "]";
	}
	
	

}
