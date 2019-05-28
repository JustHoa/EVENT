package com.n2h.EventManagement.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "activity")

public class Activity implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idactivity;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "start", nullable = false)
	private String start;
	
	@Column(name = "end", nullable = false)
	private String end;	
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "prime", nullable = true)
	private String prime;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "idevent", nullable = false)
	private Event event;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, optional = false)
	@JoinColumn(name = "idtemplate", nullable = true)
	private ActivityTemplate actTemplate;

	public Activity() {
		super();
	}

	public Activity(String name, String start, String end, String description, String prime, Event event,
			ActivityTemplate actTemplate) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.description = description;
		this.prime = prime;
		this.event = event;
		this.actTemplate = actTemplate;
	}

	public Integer getIdActivity() {
		return idactivity;
	}

	public void setIdActivity(Integer actId) {
		this.idactivity = actId;
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

	public String getPrime() {
		return prime;
	}

	public void setPrime(String prime) {
		this.prime = prime;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public ActivityTemplate getActTemplate() {
		return actTemplate;
	}

	public void setActTemplate(ActivityTemplate actTemplate) {
		this.actTemplate = actTemplate;
	}
	
	
}
