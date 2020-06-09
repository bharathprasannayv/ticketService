package com.ticketservice.ticketservice.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ticketservice.ticketservice.entity.TaskEntity;
@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long>{
	
	 Optional<TaskEntity> findByIdAndTicketId(Long id, Long ticketId);

}
