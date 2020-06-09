package com.ticketservice.ticketservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticketservice.ticketservice.entity.TicketEntity;

@Repository
public interface TicketRepositiory extends CrudRepository<TicketEntity, Long> {

}
