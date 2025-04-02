package com.oneToMany.uni.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDto {

	private String CoursName;
	
	private List<TopicDto> topics;
}
