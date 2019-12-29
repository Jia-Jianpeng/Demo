package com.jjp.utils;

import org.joda.time.DateTime;

import com.jjp.model.Ticket;

public class TicketUtils {
	public static Ticket next(int uid){

		Ticket ticket = new Ticket();
		ticket.setTicket(UuidUtils.next());
		ticket.setUserId(uid);
		//设置t票过期时间
		DateTime expiredTime = new DateTime();
		expiredTime = expiredTime.plusMonths(3);
		ticket.setExpiredAt(expiredTime.toDate());

		return ticket;
	}

	public static Ticket update(Ticket t) {
		//设置t票过期时间
		DateTime expiredTime = new DateTime();
		expiredTime = expiredTime.plusMonths(3);
		t.setExpiredAt(expiredTime.toDate());
		return t;
	}
}
