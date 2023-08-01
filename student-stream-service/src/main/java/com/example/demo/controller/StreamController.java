package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Stream;
import com.example.demo.service.StreamService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/streams")
@AllArgsConstructor
public class StreamController {

private final StreamService streamService;
	
	@PostMapping
	public ResponseEntity<Stream> createStream(@RequestBody Stream stream)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(streamService.createStream(stream));
	}
	@GetMapping("/status")
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.status(HttpStatus.OK).body("status ok");
	}
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") String id)
    {
    	Optional<Stream> o=streamService.findStream(id);
    	if(o.isEmpty())
    	   return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no student found with this id");
    	else
    	     return ResponseEntity.status(HttpStatus.OK).body(o.get());
    }
    @GetMapping
    public ResponseEntity<List<Stream>> listAll()
    {
    	return ResponseEntity.status(HttpStatus.OK).body(streamService.getAllStream());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletebyId(@PathVariable("id") String id)
    {
    	Stream s=streamService.delete(id);
    	if(s==null)
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no student found with that id");
    	else
    		return ResponseEntity.status(HttpStatus.OK).body(s);
    }
}
