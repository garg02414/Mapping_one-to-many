package com.oneToMany.uni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneToMany.uni.dto.TopicDto;
import com.oneToMany.uni.entity.Course;
import com.oneToMany.uni.entity.Topic;
import com.oneToMany.uni.repository.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public void saveTopics(TopicDto topicDto) {

		Topic topic = new Topic();
		topic.setTopicName(topicDto.getTopicName());
		
		Course course = new Course();
		course.setCoursName(topicDto.getCourse().getCoursName());
		topic.setCourse(course);
		
		topicRepository.save(topic);

	}

	public Topic geTopicById(int topicId) throws Exception {
		
		
		
		return topicRepository.findById(topicId).orElseThrow(()-> new Exception("topic Not found " + topicId));
	}
	
}







