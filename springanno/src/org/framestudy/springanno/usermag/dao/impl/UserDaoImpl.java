package org.framestudy.springanno.usermag.dao.impl;

import org.framestudy.springanno.bean.UserBean;
import org.framestudy.springanno.usermag.dao.IUserDao;
import org.framestudy.springanno.usermag.mapper.UserMapper;
import org.springframework.stereotype.Repository;
/**
 * 用户持久层实现类
 * hibernate 框架的实现
 * @author puxubo
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {
	
	private UserMapper userMapper;
	
	@Override
	public void saveUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userMapper.saveUserBean(user);
	}

	@Override
	public void updateUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userMapper.updateUserBean(user);
	}

	@Override
	public void deleteUserBean(UserBean user) {
		// TODO Auto-generated method stub
		userMapper.deleteUserBean(user);
	}

	@Override
	public UserBean getUserBeanById(Long id) {
		// TODO Auto-generated method stub
		return userMapper.getUserBeanById(id);
	}

}
