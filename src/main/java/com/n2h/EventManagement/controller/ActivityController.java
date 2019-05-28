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
import org.springframework.web.bind.annotation.RestController;

import com.n2h.EventManagement.model.Activity;
import com.n2h.EventManagement.model.ActivityTemplate;
import com.n2h.EventManagement.model.Event;
import com.n2h.EventManagement.repository.ActTemRepository;
import com.n2h.EventManagement.repository.ActivityRepository;
import com.n2h.EventManagement.repository.EventRepository;

@RestController
public class ActivityController {
	@Autowired
	private ActivityRepository activityRepository;
	@Autowired
	private ActTemRepository temRepository;
	@Autowired
	private EventRepository eventRepository;
	
	@GetMapping("/activity")
	public Iterable findAll() {
		return activityRepository.findAll();
	}
	
	@GetMapping("/activity/seach/{name}")
	public Iterable findByName(@PathVariable("name") String name) {
		return activityRepository.findByName(name);
	}
	
	@GetMapping("/activity/event/{id}")
	public List searchByIdEvent(@PathVariable("id") Integer id) {
        return activityRepository.findByEventIdevent(id);
    }
	
	@GetMapping("/activity/{id}")
	public Optional<Activity> searchById(@PathVariable("id") Integer id) {
        return activityRepository.findById(id);
    }
	
	@PostMapping("/activity/create")
	public Activity createActivity(@RequestBody Activity newActivity) {
		return activityRepository.save(newActivity);
	}
	
//	@PutMapping("/activity/replace/{id}")
//	public Activity replaceActById(@RequestBody Activity replaceAct, @PathVariable Integer id) {
//		ActivityTemplate actTemp = new ActivityTemplate();
//		return activityRepository.findById(id)
//				.map(act -> {
//			    	  act.setName(replaceAct.getName());
//			    	  act.setEnd(replaceAct.getEnd());
//			    	  act.setStart(replaceAct.getStart());
//			    	  act.setDescription(replaceAct.getDescription());
//			    	  act.setPrime(replaceAct.getPrime());
//			    	  act.setEvent(replaceAct.getEvent());
//			    	  //act.setActTemplate(replaceAct.getActTemplate().getIdtemplate());
//			    	  return activityRepository.save(act);
//			      })
//			      .orElseGet(() -> {
////			    	  replaceAct.setIdActivity(id);
//			        return activityRepository.save(replaceAct);
//			      });
//	}
	
	@DeleteMapping("/activity/delete/{id}")
	public String deleteActivity(@PathVariable int id) {
		activityRepository.deleteById(id);
		return "Xóa thành công";
	}
	
	@PutMapping("/activity/replace/{id}")
	public Activity replaceActivity(@RequestBody Activity replaceAct, @PathVariable Integer id) {
		Event event = new Event();
		ActivityTemplate actTemp = new ActivityTemplate();
		eventRepository.findById(replaceAct.getEvent().getIdEvent())
		.map(eve -> {
			event.setIdEvent(replaceAct.getEvent().getIdEvent());
			event.setName(eve.getName());
			event.setStart(eve.getStart());
			event.setEnd(eve.getEnd());
			event.setDescription(eve.getDescription());
			event.setHost(eve.getHost());
			return event;
	      });
		temRepository.findById(replaceAct.getActTemplate().getIdtemplate())
		.map(temp -> {
			actTemp.setIdtemplate(replaceAct.getActTemplate().getIdtemplate());
			actTemp.setDname(temp.getDname());
			actTemp.setDstart(temp.getDstart());
			actTemp.setDend(temp.getDend());
			actTemp.setDescription(temp.getDescription());
			actTemp.setDprime(temp.getDprime());
			actTemp.setStatus(temp.getStatus());
			return actTemp;
		});
			
		//Activity activity = new Activity();
		return activityRepository.findById(id)
				.map(act -> {
			    	  act.setName(replaceAct.getName());
			    	  act.setEnd(replaceAct.getEnd());
			    	  act.setStart(replaceAct.getStart());
			    	  act.setDescription(replaceAct.getDescription());
			    	  act.setPrime(replaceAct.getPrime());
			    	  act.setEvent(event);
			    	  act.setActTemplate(actTemp);
			    	  return activityRepository.save(act);
			      })
			      .orElseGet(() -> {
			        return activityRepository.save(replaceAct);
			      });
	}
	
	@PostMapping("/activity/create/{idEvent}/{idTemp}")
	public Activity createActivityByTem(@PathVariable Integer idEvent, @PathVariable Integer idTemp) {
		Event event = new Event();
		ActivityTemplate actTemp = new ActivityTemplate();
		eventRepository.findById(idEvent)
		.map(eve -> {
			event.setIdEvent(idEvent);
			event.setName(eve.getName());
			event.setStart(eve.getStart());
			event.setEnd(eve.getEnd());
			event.setDescription(eve.getDescription());
			event.setHost(eve.getHost());
			return event;
	      });
		temRepository.findById(idTemp)
		.map(temp -> {
			actTemp.setIdtemplate(idTemp);
			actTemp.setDname(temp.getDname());
			actTemp.setDstart(temp.getDstart());
			actTemp.setDend(temp.getDend());
			actTemp.setDescription(temp.getDescription());
			actTemp.setDprime(temp.getDprime());
			actTemp.setStatus(temp.getStatus());
			return actTemp;
		});
			
		Activity activity = new Activity();
		activity.setName(actTemp.getDname());
		activity.setStart(actTemp.getDstart());
		activity.setEnd(actTemp.getDend());
		activity.setDescription(actTemp.getDescription());
		activity.setPrime(actTemp.getDprime());
		activity.setEvent(event);
		activity.setActTemplate(actTemp);
//		return activityRepository.findById(id)
//				.map(act -> {
//			    	  act.setName(newAct.getName());
//			    	  act.setEnd(newAct.getEnd());
//			    	  act.setStart(newAct.getStart());
//			    	  act.setDescription(newAct.getDescription());
//			    	  act.setPrime(newAct.getPrime());
//			    	  act.setEvent(event);
//			    	  act.setActTemplate(actTemp);
//			    	  return activityRepository.save(act);
//			      })
//			      .orElseGet(() -> {
////			    	  replaceAct.setIdActivity(id);
//			        return activityRepository.save(newAct);
//			      });
		return activityRepository.save(activity);
	}
}
