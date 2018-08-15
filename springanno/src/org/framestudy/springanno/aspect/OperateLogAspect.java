package org.framestudy.springanno.aspect;

import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.framestudy.springanno.annotation.MyLog;
import org.framestudy.springanno.bean.OperateLogBean;
import org.framestudy.springanno.logmag.dao.IOperateLogDao;
import org.springframework.stereotype.Component;

/**
 * 操作日志切面
 * @author puxubo
 *
 */
@Aspect
@Component
public class OperateLogAspect {

	@Resource
	private IOperateLogDao operateLogDaoImpl;
	
	@Pointcut(value="@annotation(org.framestudy.springanno.annotation.MyLog)")
	private void pointcut() {}
	
	/**
	 * 后置返回通知
	 * 该通知执行在目标方法正常执行成功之后
	 * @param jp 连接点
	 * @param rev 目标方法的返回结果
	 */
	@AfterReturning(pointcut="pointcut() && @annotation(myLog) ",returning="rev")
	public void afterReturningAdvice(JoinPoint jp,MyLog myLog,Object rev) {
		Object[] args = jp.getArgs();
		//设置操作日志数据
		OperateLogBean log = new OperateLogBean();
		log.setUserName("哈哈");
		log.setOperateTime(new Date());
		log.setMenuName(myLog.menuName());//操作是哪一个模块？
		log.setOperateType(myLog.operateType().getType());//进行的什么操作？
		log.setOperateData(Arrays.toString(args));
		
		operateLogDaoImpl.saveOperateLog(log);
	}
	
	/**
	 * 前置通知
	 * 该通知执行在目标对象的目标方法执行之前
	 * 目标对象 在切面上，实际上是代理对象
	 * jp 连接点
	 */
//	@Before(value="pointcut()")
//	public void beforeAdvice(JoinPoint jp) {
//		System.out.println("前置通知----start");
//		Object target = jp.getTarget();
//		System.out.println(target);//获取目标对象（代理对象），但是给你地址：是真实对象的地址
//		System.out.println(jp.getSignature().getName());//获取哪一个方法，正在被该切面切入
//		System.out.println(Arrays.toString(jp.getArgs()));//获取方法接收到的参数
//		
//		Class<?> cls = target.getClass();
//		try {
//			Field field = cls.getDeclaredField("userName");
//			field.setAccessible(true);//授权操作私有属性
//			field.set(target, "小丽");
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("前置通知----end");
//	}
	
	/**
	 * 后置异常通知
	 * 该通知执行在目标方法抛出异常之后
	 * @param jp 连接点
	 * @param e 目标方法抛出的异常对象
	 */
//	@AfterThrowing(pointcut="pointcut()",throwing="e")
//	public void afterThrowingAdvice(JoinPoint jp,Exception e) {
//		System.out.println("后置异常通知----start");
//		System.out.println(e);
//		System.out.println("后置异常通知----end");
//	}
	/**
	 * 后置通知
	 * 该通知，无论目标方法，是否正常执行，都需要执行
	 * 类似于try--catch--finally中finally
	 * @param jp
	 */
//	@After(value="pointcut()")
//	public void afterAdvice(JoinPoint jp) {
//		System.out.println("后置通知----start");
//		System.out.println("后置通知----end");
//		
//	}
	/**
	 * 环绕通知
	 * 该通知约等于前置+后置
	 * 相当于环绕在目标方法的四周
	 * 它是唯一的一个可以控制目标方法是否执行，
	 * 以及可以修改参数，或者修改返回的通知
	 * 
	 * @param jp
	 * @return
	 */
//	@Around(value="pointcut()")
//	public Object aroundAdvice(ProceedingJoinPoint jp) {
//		//获得目标方法接到到的参数
//		Object[] args = jp.getArgs();
//		UserBean user = new UserBean();
//		user.setId(3L);
//		user.setUserName("阿奇");
//		user.setPassword("123456");
//		args[0] = user;
//		Object obj = null;
//		try {
//			//调用目标方法执行，以及获取目标方法的执行结果
//			obj = jp.proceed(args);
//			
//			System.out.println("环绕通知收到的返回：" + obj);
//			UserBean user2 = new UserBean();
//			user2.setId(5L);
//			user2.setUserName("阿毛");
//			user2.setPassword("123456");
//			obj = user2;
//			
//		} catch (Throwable e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return obj;
//	}
//	
	
}
