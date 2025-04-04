package com.oneToMany.uni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.oneToMany.uni.dto.CourseDto;
import com.oneToMany.uni.dto.TopicDto;
import com.oneToMany.uni.entity.Course;
import com.oneToMany.uni.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@PostMapping("/saveCouse")
	public void saveCourse(@RequestBody CourseDto courseDto) {
		courseService.saveCourse(courseDto);
	}
	
	@PostMapping("/addTopic/{courseId}")
	public void addTopic(@RequestBody TopicDto topic, @PathVariable int courseId) throws Exception {
		
		courseService.addTopic(topic,courseId);
	}
	
	@GetMapping("/getCourseById/{courseId}")
	public Course getCourseById(@PathVariable int courseId) throws Exception {
		
		return courseService.getCourseById(courseId);
		
	}
	
	@GetMapping("/getCourseList")
	public List<Course> getCourseList(){
		
		return courseService.getCourseList();
	}
	
	@DeleteMapping("/deleteById/{courseId}")
	public void deleteCourseByid(@PathVariable int courseId) {
		courseService.deleteCourseByid(courseId);
	}
}








