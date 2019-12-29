package com.jjp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jjp.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	Ticket findByUserId(int uid);
	Ticket findByTicket(String ticket);
}
