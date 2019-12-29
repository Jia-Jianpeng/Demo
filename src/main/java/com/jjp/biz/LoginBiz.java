package com.jjp.biz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjp.model.Ticket;
import com.jjp.model.User;
import com.jjp.model.exceptions.LoginRegisterException;
import com.jjp.service.TicketService;
import com.jjp.service.UserService;
import com.jjp.utils.ConcurrentUtils;
import com.jjp.utils.MD5;
import com.jjp.utils.TicketUtils;

@Service
public class LoginBiz {
	
	@Autowired
	private UserService userServiceImpl;
	
	@Autowired
	private TicketService ticketServiceImpl;
	/**
	 * 登录逻辑，先检查邮箱和密码，然后更新t票。
	 * @return 返回最新t票
	 * @throws Exception 账号密码错误
	 */
	public String login(String email, String password) throws Exception{
		
		User user = userServiceImpl.getUser(email);
		if(user == null) {
			throw new LoginRegisterException("用户名不存在");
		}
		
		if(!StringUtils.equals(user.getPassword(), MD5.next(password))) {
			throw new LoginRegisterException("用户名或密码错误");
		}
		
		Ticket ticket = ticketServiceImpl.getTicket(user.getId());
		if(ticket == null) {
			ticket = TicketUtils.next(user.getId());
			ticketServiceImpl.addTicket(ticket);
			return ticket.getTicket();
		}
		
		ticket = TicketUtils.update(ticket);
		ticketServiceImpl.addTicket(ticket);
		return ticket.getTicket();
	}
	

	  /**
	   * 用户退出登录，只需要删除数据库中用户的t票
	   * @param t
	   */
	  public void logout(String t){
	    ticketServiceImpl.deleteTicket(t);
	  }
	  
	  /**
	   * 注册一个用户，并返回用户t票
	   *
	   * @return 用户当前的t票
	   */
	  public String register(User user) throws Exception {

	    //信息检查
	    if (userServiceImpl.getUser(user.getEmail()) != null) {
	      throw new LoginRegisterException("用户邮箱已经存在！");
	    }

	    //密码加密
	    String plain = user.getPassword();
	    String md5 = MD5.next(plain);
	    user.setPassword(md5);
	    //数据库添加用户
	    userServiceImpl.addUser(user);

	    //生成用户t票
	    Ticket ticket = TicketUtils.next(user.getId());
	    //数据库添加t票
	    ticketServiceImpl.addTicket(ticket);

	    //ConcurrentUtils.setHost(user);
	    System.out.println(ConcurrentUtils.getHost());
	    return ticket.getTicket();

	  }
}
