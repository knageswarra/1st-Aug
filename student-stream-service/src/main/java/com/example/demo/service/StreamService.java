package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Stream;

public interface StreamService {
	Stream createStream(Stream stream);
	Optional<Stream> findStream(String id);
	List<Stream> getAllStream();
	Stream delete(String id);
}
