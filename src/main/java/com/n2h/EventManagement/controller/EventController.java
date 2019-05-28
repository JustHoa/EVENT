package com.n2h.EventManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.n2h.EventManagement.model.Event;
import com.n2h.EventManagement.repository.EventRepository;

@RestController
public class EventController {
	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping("/event")
    public Iterable findAll() {
        return eventRepository.findAll();
    }
	
	@GetMapping("/event/search/{name}")
    public List search(@PathVariable("name") String term) {
        return eventRepository.findByName(term);
    }
	
	@GetMapping("/event/searchById/{id}")
    public Optional<Event> searchById(@PathVariable("id") Integer id) {
        return eventRepository.findById(id);
    }
	
	@PostMapping("/event/create")
	public Event createEvent(@RequestBody Event newEvent) {
		return eventRepository.save(newEvent);
	}
	 @PutMapping("/event/{id}")
	 public Event replaceEventByID(@RequestBody Event replaceEvent, @PathVariable int id) {
		 return eventRepository.findById(id)
			      .map(event -> {
			    	  event.setName(replaceEvent.getName());
			    	  event.setStart(replaceEvent.getStart());
			    	  event.setEnd(replaceEvent.getEnd());
			    	  event.setDescription(replaceEvent.getDescription());
			    	  event.setHost(replaceEvent.getHost());
			    	  return eventRepository.save(event);
			      })
			      .orElseGet(() -> {
			    	  //replaceEvent.setIdEvent(id);
			        return eventRepository.save(replaceEvent);
			      });
	 }
	 @DeleteMapping("/event/delete/{id}")
	  void deleteEvent(@PathVariable int id) {
		 eventRepository.deleteById(id);
	  }
}
