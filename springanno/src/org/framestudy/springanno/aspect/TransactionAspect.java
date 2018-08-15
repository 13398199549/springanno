package org.framestudy.springanno.aspect;

import java.lang.reflect.Field;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.framestudy.springanno.tool.MyBatisUtil;
import org.springframework.stereotype.Component;

/**
 * 数据库事务切面
 * @author puxubo
 *
 */
@Aspect
@Component
public class TransactionAspect {
	
	@Pointcut(value="execution(* org.framestudy.springanno.*mag.dao.impl.*DaoImpl.*(..))")
	private void pointcut() {}
	
	private SqlSession session;
	
	/**
	 * 获取Session
	 * @param jp
	 */
	@Before(value="pointcut()")
	public void beforeAdvice(JoinPoint jp) {
		session = MyBatisUtil.getSqlSession();
		Object obj = jp.getTarget();//获得目标对象
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		try {
			
			for (Field field : fields) {
				field.setAccessible(true);
				field.set(obj, session.getMapper(field.getType()));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	/**
	 * Session提交
	 * @param jp
	 * @param rev
	 */
	@AfterReturning(pointcut="pointcut()",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,Object rev) {
		session.commit();
		session.close();
	}
	/**
	 * Session回滚
	 * @param jp
	 * @param e
	 */
	@AfterThrowing(pointcut="pointcut()",throwing="e")
	public void afterThrowingAdvice(JoinPoint jp,Exception e) {
		session.rollback();
		session.close();
	}
}
