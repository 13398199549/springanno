package org.framestudy.springanno.usermag.service.impl;

import javax.annotation.Resource;

import org.framestudy.springanno.annotation.MyLog;
import org.framestudy.springanno.bean.UserBean;
import org.framestudy.springanno.enmu.OperateLogEnum;
import org.framestudy.springanno.usermag.dao.IUserDao;
import org.framestudy.springanno.usermag.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务实现类
 * 
 * @author puxubo
 *
 */
@Service
public class UserServiceImpl implements IUserService {
	
	/**
	 * @Autowired 模糊装配，默认情况下，采用byType
	 * @Qualifier 精准装配，采用byName
	 * @Autowired
	 * @Qualifier(value="userMybatisDaoImpl")
	 * 
	 * @Resource
	 * 默认情况下，采用byName进行精准装配，如果装配不成功，
	 * 回退到byType模糊装配/
	 */
	@Resource
	private IUserDao userDaoImpl;

	@MyLog(menuName="用户管理",operateType=OperateLogEnum.SAVE)
	@Override
	public UserBean saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.saveUserBean(user);
		return user;
	}

	@MyLog(menuName="用户管理",operateType=OperateLogEnum.UPDATE)
	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.updateUserBean(user);
	}

	@MyLog(menuName="用户管理",operateType=OperateLogEnum.DELETE)
	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userDaoImpl.deleteUserBean(user);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userDaoImpl.getUserBeanById(id);
	}

	
	
	
//	/**
//	 * 实例的初始化方法
//	 * 组件的实例创建完毕之后，需要执行的初始化方法
//	 */
//	@PostConstruct
//	private void init() {
//		System.out.println("UserServiceImpl 已经实例化了，现在将进行参数的初始化！");
//	}
//	
//	/**
//	 * 实例销毁之前，需要执行的收尾的方法
//	 */
//	@PreDestroy
//	private void destory() {
//		System.out.println("UserServiceImpl 将被容器销毁了……");
//	}
	
}
