package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entity.PortfolioClass;
import com.example.entity.ShareClass;

public interface PortfolioRepo extends JpaRepository<PortfolioClass, Integer> {

	

}