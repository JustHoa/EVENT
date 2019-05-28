package com.n2h.EventManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.n2h.EventManagement.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Integer>{
	List<Activity> findByName(String name);
	List<Activity> findByEventIdevent(Integer idevent);
}
