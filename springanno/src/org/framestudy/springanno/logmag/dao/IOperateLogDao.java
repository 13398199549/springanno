package org.framestudy.springanno.logmag.dao;

import org.framestudy.springanno.bean.OperateLogBean;
/**
 * 操作日志持久层接口
 * @author DELL
 *
 */
public interface IOperateLogDao {
	/**
	 * 保存操作日志
	 * @param log
	 */
	void saveOperateLog(OperateLogBean log);
	
	/**
	 * 操作日志分页方法
	 */
}
