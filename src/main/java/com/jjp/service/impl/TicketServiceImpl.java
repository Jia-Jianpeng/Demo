package com.jjp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jjp.model.Ticket;
import com.jjp.repository.TicketRepository;
import com.jjp.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	@Override
	public void addTicket(Ticket t) {
		ticketRepository.save(t);
	}
	
	@Override
	public Ticket getTicket(int uid) {
		return ticketRepository.findByUserId(uid);
	}

	@Override
	public Ticket getTicket(String t) {
		return ticketRepository.findByTicket(t);
	}

	@Override
	public void deleteTicket(int tid) {
		ticketRepository.deleteById(Integer.valueOf(tid));
	}

	@Override
	public void deleteTicket(String t) {
		Ticket ticket = ticketRepository.findByTicket(t);
		ticketRepository.delete(ticket);
	}

}
