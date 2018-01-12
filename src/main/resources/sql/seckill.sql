-- 秒杀存储过程
DELIMITER $$ -- console;  转换为%%
CREATE PROCEDURE seckill.execute_seckill
-- 参数: in 输入参数 out 输出参数
-- IGNORE 不报错返回数字
-- ROW_COUNT() 返回上一条修改类型sql（selete,insert,update）的影响行数
-- ROW_COUNT()  0为修改 >0 修改的行数 <0 sql错误
(in v_seckill_id BIGINT,in v_phone BIGINT,in v_kill_time TIMESTAMP,out r_result int)
BEGIN 
	DECLARE insert_count int default 0;
  START TRANSACTION;
	insert IGNORE INTO success_killed(seckill_id,user_phone,create_time,state)
	VALUES (v_seckill_id,v_phone,v_kill_time,0);
	select ROW_COUNT() into insert_count;
	IF(insert_count = 0) THEN 
		ROLLBACK;
		SET r_result = -1;
	ELSEIF(insert_count < 0) THEN
		ROLLBACK;
		SET r_result = -2;
	ELSE
			UPDATE seckill
			set number=number-1
			WHERE seckill_id = v_seckill_id
			and end_time > v_kill_time
			and start_time < v_kill_time
			and number>0;
			select ROW_COUNT() into insert_count;
			IF(insert_count=0) THEN
				ROLLBACK;
				SET r_result = -2;
			ELSE
				COMMIT;
				SET r_result = 1;
			END IF;
	END IF;
END;
$$
-- 存储过程定义结束


