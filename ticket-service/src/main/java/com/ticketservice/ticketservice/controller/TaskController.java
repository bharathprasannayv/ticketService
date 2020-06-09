package com.ticketservice.ticketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketservice.ticketservice.dao.TaskRepository;
import com.ticketservice.ticketservice.dao.TicketRepositiory;
import com.ticketservice.ticketservice.entity.TaskEntity;
import com.ticketservice.ticketservice.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/tasks")
public class TaskController {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	TicketRepositiory ticketRepositiory;

	@GetMapping("/")
	public List<TaskEntity> getAllTasks() {
		return (List<TaskEntity>) taskRepository.findAll();
	}

	@PostMapping("/ticket/{ticketId}")
	public TaskEntity createTask(@PathVariable(value = "ticketId") Long ticketId,
			@Validated @RequestBody TaskEntity task) {
		return ticketRepositiory.findById(ticketId).map(ticket -> {
			task.setTicket(ticket);
			return taskRepository.save(task);
		}).orElseThrow(() -> new ResourceNotFoundException("Ticket Id:  " + ticketId + " not found"));
	}
	
	
	@DeleteMapping("/tickets/{ticketId}/tasks/{taskId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "ticketId") Long ticketId,
                              @PathVariable (value = "taskId") Long taskId) {
        return taskRepository.findByIdAndTicketId(taskId, ticketId).map(comment -> {
        	taskRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId + " and ticketId " + ticketId));
    }
}
