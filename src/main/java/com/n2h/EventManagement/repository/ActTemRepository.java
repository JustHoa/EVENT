package com.n2h.EventManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.n2h.EventManagement.model.ActivityTemplate;

public interface ActTemRepository extends CrudRepository<ActivityTemplate, Integer>{
	List<ActivityTemplate> findByDname(String name);
	List<ActivityTemplate> findByStatus(String status);
}
