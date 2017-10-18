package cc.service;

import cc.dao.UserMapper;
import cc.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public int insert(User user) {
		//User u = new User();
		//BeanUtils.copyProperties(user, u, new String[] { "pwd" });
		//u.setId(UUID.randomUUID().toString());
		//u.setPwd(Encrypt.e(user.getPwd()));
		//BeanUtils.copyProperties(u, user);
		return userMapper.insert(user);
	}
}
