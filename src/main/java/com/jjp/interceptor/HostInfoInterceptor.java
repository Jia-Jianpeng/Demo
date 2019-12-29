package com.jjp.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.jjp.model.Ticket;
import com.jjp.model.User;
import com.jjp.service.TicketService;
import com.jjp.service.UserService;
import com.jjp.utils.ConcurrentUtils;
import com.jjp.utils.CookieUtils;

@Component
public class HostInfoInterceptor implements HandlerInterceptor {
	@Autowired
	private TicketService ticketService;

	@Autowired
	private UserService userService;

	/**
	 * 为注入host信息
	 *
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String t = CookieUtils.getCookie("t", request);
		if (!StringUtils.isEmpty(t)) {
			Ticket ticket = ticketService.getTicket(t);
			if (ticket != null && ticket.getExpiredAt().after(new Date())) {
				User host = userService.getUser(ticket.getUserId());
				ConcurrentUtils.setHost(host);
			}
			else
				ConcurrentUtils.setHost(null);
		}
		else
			ConcurrentUtils.setHost(null);
		return true;
	}
}
