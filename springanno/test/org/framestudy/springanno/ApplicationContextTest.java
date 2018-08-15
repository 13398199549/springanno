package org.framestudy.springanno;

import java.util.Date;

import javax.annotation.Resource;

import org.framestudy.springanno.bean.UserBean;
import org.framestudy.springanno.usermag.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class ApplicationContextTest {
	
	@Resource
	private IUserService userServiceImpl;
	
	
	@Test
	public void updateUserBean() {
		UserBean user = new UserBean();
		user.setId(1L);
		user.setUserName("李四");
		user.setPassword("123456");
		user.setUpdateTime(new Date());
		userServiceImpl.updateUserBean(user);
	}
	
	@Test
	public void saveUserBean() {
		UserBean user = new UserBean();
		user.setId(1L);
		user.setUserName("张三");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		userServiceImpl.saveUserBean(user);
	}
	
}
