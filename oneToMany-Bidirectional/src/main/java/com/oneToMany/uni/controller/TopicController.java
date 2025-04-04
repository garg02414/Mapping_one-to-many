package com.oneToMany.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneToMany.uni.dto.TopicDto;
import com.oneToMany.uni.entity.Topic;
import com.oneToMany.uni.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@PostMapping("/saveTopic")
	public void saveTopics(@RequestBody TopicDto topicDto) {
		
		topicService.saveTopics(topicDto);
		
	}
	
	@GetMapping("/getTopicById/{topicId}")
	public Topic getTopicById(@PathVariable int topicId) throws Exception {
		return topicService.geTopicById(topicId);
	}
	
	
}
