package com.oneToMany.uni.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneToMany.uni.dto.CourseDto;
import com.oneToMany.uni.dto.TopicDto;
import com.oneToMany.uni.entity.Course;
import com.oneToMany.uni.entity.Topic;
import com.oneToMany.uni.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public void saveCourse(CourseDto courseDto) {
		
		Course course =  new Course();
		
		course.setCoursName(courseDto.getCoursName());
		
		List<Topic> ListOfTopic = courseDto.getTopics().stream()
				.map(oneTopic -> converCourseDtoToEntity(oneTopic))
				.collect(Collectors.toList());
		course.setTopics(ListOfTopic);
		
		courseRepository.save(course);
	}

	private Topic converCourseDtoToEntity(TopicDto oneTopic) {
		
		Topic topic = new Topic();
		topic.setTopicName(oneTopic.getTopicName());
		return topic;
	}

	public void addTopic(TopicDto topic, int courseId) throws Exception {

		Course course = courseRepository.findById(courseId).orElseThrow(()-> new Exception("course not found "+ courseId));
		
		Topic topicEntity = new Topic();
		topicEntity.setTopicName(topic.getTopicName());
		
		course.getTopics().add(topicEntity);
		
		courseRepository.save(course);
	}

	public Course getCourseById(int courseId) throws Exception {	
		
		return courseRepository.findById(courseId).orElseThrow(()-> new Exception("course not found "+ courseId));
	}

	public List<Course> getCourseList() {

		return courseRepository.findAll();
	}

	public void deleteCourseByid(int courseId) {
		
		courseRepository.deleteById(courseId);
	}

}









