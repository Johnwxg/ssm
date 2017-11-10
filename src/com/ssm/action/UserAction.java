package com.ssm.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.ssm.bean.User;
import com.ssm.exception.SelfException;
import com.ssm.service.UserService;


/*Spring在Action上面注解@Scope("prototype"),表示每次接收一个请求创建一个Action对象,清除action中信息对下一个请求是影响*/
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UserAction.class);
	
	/*@Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。 通过 @Autowired的使用来消除 set ，get方法。*/
	private User user;
	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * @param user
	 * @return
	 * @throws SelfException
	 */
	public String login() throws SelfException{
//		ActionContext actionContext = ActionContext.getContext();
		LOGGER.info("hello");
		if(user!=null){
			String aString = user.getUsernm();
			LOGGER.info(aString);
			User userInfo = userService.queryUserInfo(user);
			if(userInfo!=null){
				LOGGER.info(userInfo.getPwd());
				return "success";
			}
		}
		this.addFieldError("user.username", "用户名或密码错误!");  
		return INPUT;
	}
	
	public String queryUserInfo(User userinfo) throws SelfException{
		System.out.println("1");
        return INPUT; 
	}	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
