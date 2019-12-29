package com.jjp.service;

import com.jjp.model.Ticket;

public interface TicketService {
	
	public void addTicket(Ticket t);
	
	public Ticket getTicket(int uid);
	
	public Ticket getTicket(String t);
	
	public void deleteTicket(int tid);
	
	public void deleteTicket(String t);
	
}
