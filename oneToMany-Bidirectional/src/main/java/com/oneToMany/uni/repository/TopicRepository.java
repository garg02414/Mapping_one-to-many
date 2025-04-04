package com.oneToMany.uni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oneToMany.uni.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer>{

}
