package com.everistest.springboot.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired 
	TaskRepository taskRepository;
	
	public List<Task> getAllTask() {
		List<Task> task = new ArrayList<>();  
		taskRepository.findAll()
		.forEach(task::add);  
		return task;  
	}
	
	public Task getTask(String name) {
		return  taskRepository.findById(name).get();  
	}
	
	public void addTask(Task task) {
		taskRepository.save(task);
	}
	

	public void updateTask(Task task, String name) {
		taskRepository.save(task);
	}

	public void deleteTask(String name) {
		taskRepository.deleteById(name);
	}

	public List<Task> getTaskFilter(String status) {
		List<Task> task = new ArrayList<>();  
		taskRepository.findAll()
		.forEach(task::add);  
		List<Task> taskfilter = new ArrayList<>();
		for (int i = 0; i < task.size(); i++) {
			Task t = task.get(i);
			if(t.getStatus().equals(status)) {
				taskfilter.add(t);
			}
		}
		return taskfilter;	
	}
}
