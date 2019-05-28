package com.n2h.EventManagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "event")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Event implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idevent;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "start", nullable = false)
	private String start;
	
	@Column(name = "end", nullable = false)
	private String end;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "host", nullable = true)
	private String host;

	public Event() {
		super();
	}

	public Event(String name, String start, String end, String description, String host) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.description = description;
		this.host = host;
	}

	public Integer getIdEvent() {
		return idevent;
	}

	public void setIdEvent(Integer id) {
		this.idevent = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	
}
