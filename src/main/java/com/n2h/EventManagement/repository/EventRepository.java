package com.n2h.EventManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.n2h.EventManagement.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer>{
	List<Event>findByName(String name);
}
