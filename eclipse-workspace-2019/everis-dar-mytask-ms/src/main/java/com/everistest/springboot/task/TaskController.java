package com.everistest.springboot.task;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskController {

	@Autowired
	private TaskService taskservice;
	
	
	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public List<Task> getAllTask(@RequestParam("status") Optional<String> status){
		if( status.isPresent()){              
	         return taskservice.getTaskFilter(status.get());
	     } else
		return taskservice.getAllTask();
	}
		
	@RequestMapping(value = "/tasks/{name}", method = RequestMethod.GET)
	public Task getTask(@PathVariable String name) {
		return taskservice.getTask(name);
	}
	
	@RequestMapping(value="/tasks", method=RequestMethod.POST)
	public void addTopic(@Valid @RequestBody Task task) {
		taskservice.addTask(task);		
	}
	
	@RequestMapping(value="/tasks/{name}", method=RequestMethod.PUT)
	public void updateTask(@Valid @RequestBody Task task, @PathVariable String name) {
		taskservice.updateTask(task, name);		
	}
	
	@RequestMapping(value="/tasks/{name}", method=RequestMethod.DELETE)
	public void deleteTask(@PathVariable String name) {
		taskservice.deleteTask(name);		
	}
}
