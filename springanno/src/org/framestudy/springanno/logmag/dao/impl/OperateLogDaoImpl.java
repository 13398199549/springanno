package org.framestudy.springanno.logmag.dao.impl;

import org.framestudy.springanno.bean.OperateLogBean;
import org.framestudy.springanno.logmag.dao.IOperateLogDao;
import org.framestudy.springanno.logmag.mapper.OperateLogMapper;
import org.springframework.stereotype.Repository;
/**
 * 操作日志持久实现类
 * @author puxubo
 *
 */
@Repository
public class OperateLogDaoImpl implements IOperateLogDao {
	
	private OperateLogMapper operateLogMapper;
	
	@Override
	public void saveOperateLog(OperateLogBean log) {
		// TODO Auto-generated method stub
		operateLogMapper.saveOperateLog(log);
	}

}
