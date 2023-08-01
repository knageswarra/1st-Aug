package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("stream_doc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stream {
	private String streamName;
	private String streamHead;

}
