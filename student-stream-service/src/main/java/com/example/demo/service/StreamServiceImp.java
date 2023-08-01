package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Stream;
import com.example.demo.repo.StreamRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StreamServiceImp implements StreamService{

	private final StreamRepository sr;
	@Override
	public Stream createStream(Stream stream) {
		// TODO Auto-generated method stub
		return sr.save(stream);
	}

	@Override
	public Optional<Stream> findStream(String id) {
		// TODO Auto-generated method stub
		return sr.findById(id);
	}

	@Override
	public List<Stream> getAllStream() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Stream delete(String id) {
		// TODO Auto-generated method stub
		Optional<Stream> o=sr.findById(id);
		if(o.isEmpty())
			return null;
		else
		    {
			sr.delete(o.get());
			return o.get();
		    }
	}

}
