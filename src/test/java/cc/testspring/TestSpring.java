package cc.testspring;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import cc.model.User;
import cc.service.UserServiceI;
import cc.util.Encrypt;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath*:/spring.xml","classpath*:/spring-mybaits.xml"})
public class TestSpring {
	@Autowired
	private UserServiceI userService;
	private ApplicationContext ac;
	private static final Logger logger=LogManager.getLogger(TestSpring.class);
	
	@Before
	public void Before() {
		ac = new ClassPathXmlApplicationContext(new String[] {"spring.xml","spring-mybatis.xml"});
		userService=(UserServiceI) ac.getBean("userService");
	}	
	@Test
	public void test1() {
		User u=userService.getUserById("12345");
		logger.error(JSON.toJSONStringWithDateFormat(u,"yyyy-MM-dd HH-mm-ss"));
		
	}
	@Test
	public void test2() {
		List<User> l= userService.getAll();
		logger.error(JSON.toJSONStringWithDateFormat(l,"yyyy-MM-dd HH-mm-ss"));
	}
	@Test
	public void test3() {
		User u= new User();
		u.setId(UUID.randomUUID().toString());
		u.setName("chenchao");
		u.setPwd(Encrypt.e("123456"));
		u.setCreatetime(new Date());
		u.setUpdatetime(new Date());
		userService.insert(u);
	}
}
