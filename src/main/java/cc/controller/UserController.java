package cc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cc.model.User;
import cc.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private UserServiceI userService;
	
	@RequestMapping("/showUser/{id}")
	public String showUser(@PathVariable String id,HttpServletRequest req) {
		System.out.println("这里是controller");
		User u = userService.getUserById(id);
		req.setAttribute("user", u);
		return "showUser";
	}
	@RequestMapping("/showAllUser")
	public String ShowAllUser(HttpServletRequest req) {
		List<User> l=userService.getAll();
		System.out.println(l);
		req.setAttribute("list", l);
		return "showAllUser";
	}
}
