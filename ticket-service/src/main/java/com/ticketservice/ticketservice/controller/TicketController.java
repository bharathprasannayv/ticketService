package com.ticketservice.ticketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketservice.ticketservice.dao.TicketRepositiory;
import com.ticketservice.ticketservice.entity.TicketEntity;
import com.ticketservice.ticketservice.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	TicketRepositiory ticketRepositiory;

	@PostMapping(value = "/")
	public TicketEntity saveTicket(@RequestBody TicketEntity ticket) {
		return ticketRepositiory.save(ticket);
	}

	@GetMapping("/")
	public List<TicketEntity> getAllTickets() {
		return (List<TicketEntity>) ticketRepositiory.findAll();
	}
	
	@DeleteMapping("/{ticketId}")
	public ResponseEntity<?> deleteTask(@PathVariable Long ticketId) {
		return ticketRepositiory.findById(ticketId).map(post -> {
			ticketRepositiory.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Ticket Id: " + ticketId + " not found"));
	}
}
