package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ShareClass;

public interface ShareRepo extends JpaRepository<ShareClass, Integer>{

}
