package com.example.demo.controller;

import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TutorialRepository;
import com.example.demo.model.Tutorial;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/tutorials")
@AllArgsConstructor
public class TutorialController {

	private Environment environment;
	
	private final TutorialRepository tr;
	
	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("service is runing on port: "+environment.getProperty("local.server.port"));
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Tutorial t)
	{
		Tutorial z=tr.save(t);
		return ResponseEntity.status(HttpStatus.OK).body(z);
	}
	
	@GetMapping
	public ResponseEntity<?> getAll()
	{
		List<Tutorial> t=tr.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(t);
	}

}
