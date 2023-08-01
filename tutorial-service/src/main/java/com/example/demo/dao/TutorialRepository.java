package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tutorial;

public interface TutorialRepository  extends JpaRepository<Tutorial, Integer>{

}
