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

import com.n2h.EventManagement.model.ActivityTemplate;
import com.n2h.EventManagement.repository.ActTemRepository;

@RestController
public class ActTemController {
	@Autowired
	private ActTemRepository templateRepository;
	
	@GetMapping("/template")
	public Iterable findAll() {
		return templateRepository.findAll();
	}
	
	@GetMapping("/template/available")
	public List<ActivityTemplate> findAvailable() {
		return templateRepository.findByStatus("1");
	}
	
	@GetMapping("/template/{id}")
	public Optional<ActivityTemplate> searchById(@PathVariable("id") Integer id) {
        return templateRepository.findById(id);
    }
	
	@GetMapping("/template/search/{name}")			//xài không được
	public List<ActivityTemplate> searchById(@PathVariable("name") String name) {
        return templateRepository.findByDname(name);
    }
	@PostMapping("/template/create")
	public ActivityTemplate createActivity(@RequestBody ActivityTemplate newTemplate) {
		return templateRepository.save(newTemplate);
	}
	
	@PutMapping("/template/replace/{id}")
	public ActivityTemplate replaceActById(@RequestBody ActivityTemplate replaceTemplate, @PathVariable Integer id) {
		return templateRepository.findById(id)
				.map(temp -> {
			    	  temp.setDname(replaceTemplate.getDname());
			    	  temp.setDstart(replaceTemplate.getDstart());
			    	  temp.setDend(replaceTemplate.getDend());
			    	  temp.setDescription(replaceTemplate.getDescription());
			    	  temp.setDprime(replaceTemplate.getDprime());
			    	  temp.setStatus(replaceTemplate.getStatus());
			    	  return templateRepository.save(temp);
			      })
			      .orElseGet(() -> {
			    	  //replaceTemplate.setIdtemplate(id);
			        return templateRepository.save(replaceTemplate);
			      });
	}
	
	@DeleteMapping("/template/delete/{id}")
	public String deleteActivity(@PathVariable int id) {
		templateRepository.deleteById(id);
		return "Xóa thành công";
	}
	
	@PutMapping("template/changestatus/{id}")
	public Optional<Object> changeStatus(@PathVariable("id") Integer id) {
		return templateRepository.findById(id)
				.map(temp -> {
			    	  temp.setStatus((temp.getStatus() == "1")?"1":"0");
			    	  return templateRepository.save(temp);
			      });
			     
	}
}
