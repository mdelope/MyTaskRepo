package com.everistest.springboot.task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table
public class Task {

    @NotEmpty(message = "Name may not be empty")
    @NotBlank
    @Id
	private String name;
    
    @NotEmpty(message = "Description may not be empty")
    @Size(min = 1, max = 32, message = "Name must be between 2 and 32 characters long") 
    @Column
	private String description;
    
    @NotEmpty(message = "Status may not be empty")
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+\\s*$")
    @Column
    private String status;
	
	public Task() {};
	
	public Task(String name, String description, String status) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
