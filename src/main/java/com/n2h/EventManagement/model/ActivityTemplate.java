package com.n2h.EventManagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
@Entity
@Table(name = "activitytemplate")
public class ActivityTemplate implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtemplate;
	
	@Column(name = "dname", nullable = false)
	private String dname;
	
	@Column(name = "dstart", nullable = false)
	private String dstart;
	
	@Column(name = "dend", nullable = false)
	private String dend;
	
	@Column(name = "ddescription", nullable = true)
	private String description;
	
	@Column(name = "dprime", nullable = true)
	private String dprime;
	
	@Column(name = "status", nullable = true)
	private String status;

	public ActivityTemplate() {
		super();
	}

	public ActivityTemplate(String dname, String dstart, String dend, String description, String dprime,
			String status) {
		super();
		this.dname = dname;
		this.dstart = dstart;
		this.dend = dend;
		this.description = description;
		this.dprime = dprime;
		this.status = status;
	}

	public Integer getIdtemplate() {
		return idtemplate;
	}

	public void setIdtemplate(Integer idtemplate) {
		this.idtemplate = idtemplate;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDstart() {
		return dstart;
	}

	public void setDstart(String dstart) {
		this.dstart = dstart;
	}

	public String getDend() {
		return dend;
	}

	public void setDend(String dend) {
		this.dend = dend;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDprime() {
		return dprime;
	}

	public void setDprime(String dprime) {
		this.dprime = dprime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
