package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Project;

public interface ProjectDao extends JpaRepository<Project, Integer> {

}
