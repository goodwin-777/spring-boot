package com.example.demo.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Macbook;
import com.example.demo.service.MacbookService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/apple")
public class MacbookRestController {
	private MacbookService macbookService;
	
	public MacbookRestController(MacbookService macbookService) {
		this.macbookService = macbookService;
	}

//	Read
	
	@GetMapping("/macbooks")
	public List<Macbook> findAllMacbooks(){
		 return macbookService.findAllMacbooks();
	};
	
	@GetMapping("/macbooks/{id}")
	public Macbook findById(@PathVariable int id) {
		return macbookService.findById(id);
	};
	
	@GetMapping("/macbooks/name/{name}")
	public List<Macbook> findByName(@PathVariable String name){
		return macbookService.findByName(name);
	};
	
	@GetMapping("/macbooks/model/{model}")
	public List<Macbook> findByModel(@PathVariable String model){
		return macbookService.findByModel(model);
	};
	
	@GetMapping("/macbooks/date/{date}")
	public List<Macbook> findByReleaseDate(@PathVariable String date){
		return macbookService.findByReleaseDate(date);
	};
	
	@GetMapping("/macbooks/color/{color}")
	public List<Macbook> findByColor(@PathVariable String color){
		return macbookService.findByColor(color);
	};
	
//	Create
	
	@PostMapping("/macbooks")
	public Macbook saveMacbook(@RequestBody Macbook macbook) {
		return macbookService.saveMacbook(macbook);
	};
	
	
//	Update
	
	@PutMapping("/macbooks")
	public Macbook updateMacbook(@RequestBody Macbook macbook) {
		return macbookService.updateMacbook(macbook);
	};
	
	
//	Delete
	
	@DeleteMapping("/macbooks/{id}")
	public String deleteMacbook(@PathVariable int id) {
		return macbookService.deleteMacbook(id);
	};
	
	@PostConstruct
	public void dbEntries() {
		Macbook macbook1 = new Macbook(0, "Air M1" , "2020", "Silver", 80000);
		Macbook macbook2 = new Macbook(0, "Pro M1", "2020", "Midnight", 99000);
		Macbook macbook3 = new Macbook(0, "Air M2" , "2022", "Gold", 110000);
		Macbook macbook4 = new Macbook(0, "Pro M1", "2020", "Space Gray", 130000);
		
		saveMacbook(macbook1);
		saveMacbook(macbook2);
		saveMacbook(macbook3);
		saveMacbook(macbook4);
	}
}
