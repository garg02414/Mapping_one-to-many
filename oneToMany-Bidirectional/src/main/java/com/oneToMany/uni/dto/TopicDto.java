package com.oneToMany.uni.dto;

import com.oneToMany.uni.entity.Course;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TopicDto {

	private String topicName;
	
	private CourseDto course;
}
